package com.StackRoute.Goplaces.services;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import com.StackRoute.Goplaces.domain.Places;
import com.StackRoute.Goplaces.repositories.PlacesRepository;
import static org.mockito.Mockito.never;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(MockitoJUnitRunner.class)
public class PlaceDBServiceSpyTest {
   @Spy
   private PlaceDatabaseServiceImpl placeDbServiceimpl;
   @Mock
   private PlacesRepository placerepository;
   @Mock
   private Places place;

 @Test(expected=NullPointerException.class)
   public void shouldThrowNullPointerException_whenGetProductByIdIsCalledWithoutContext() throws Exception {
       //Act
       Places retrievedPlace = placeDbServiceimpl.findById(5);
       //Assert
       assertThat(retrievedPlace, is(equalTo(place)));
   }
 @Test(expected=NullPointerException.class)
 public void shouldThrowNullPointerException_whenSavePlaceIsCalledWithoutContext() throws Exception {
       //Arrange
       Mockito.doReturn(place).when(placerepository).save(place);
       //Act
       Places savedPlace = placeDbServiceimpl.save(place);
       //Assert
       assertThat(savedPlace, is(equalTo(place)));
   }

  @Test
   public void shouldVerifyThatGetProductByIdIsCalled() throws Exception {
       //Arrange
       Mockito.doReturn(place).when(placeDbServiceimpl).findById(5);
       //Act
       Places retrievedPlace = placeDbServiceimpl.findById(5);
       //Assert
       Mockito.verify(placeDbServiceimpl).findById(5);
   }
   @Test
   public void shouldVerifyThatSaveProductIsNotCalled() throws Exception {
       //Arrange
       Mockito.doReturn(place).when(placeDbServiceimpl).findById(5);
       //Act
       Places retrievedPlace = placeDbServiceimpl.findById(5);
       //Assert
       Mockito.verify(placeDbServiceimpl,never()).save(place);
   }
}
