package com.StackRoute.Goplaces.services;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.StackRoute.Goplaces.domain.Places;
import com.StackRoute.Goplaces.repositories.PlacesRepository;

import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PlaceDatabaseServiceImplMockTest {

  private PlaceDatabaseServiceImpl placeDbServiceImpl;
   @Mock
   private PlacesRepository placeRepository;
   @Mock
   private Places place;
   @Before
   public void setupMock() {
       MockitoAnnotations.initMocks(this);
       placeDbServiceImpl=new PlaceDatabaseServiceImpl();
       placeDbServiceImpl.setPlacesRepository(placeRepository);
   }
   @Test
   public void shouldReturnProduct_whenGetProductByIdIsCalled() throws Exception {
       // Arrange
       when(placeRepository.findOne(5)).thenReturn(place);
       // Act
      Places retrievedPlace = placeDbServiceImpl.findById(5);
       // Assert
       assertThat(retrievedPlace, is(equalTo(place)));

  }
   @Test
   public void shouldReturnProduct_whenSaveProductIsCalled() throws Exception {
       // Arrange
       when(placeRepository.save(place)).thenReturn(place);
       // Act
      Places savedPlace = placeDbServiceImpl.save(place);
       // Assert
       assertThat(savedPlace, is(equalTo(place)));
   }
   @Test
   public void shouldCallDeleteMethodOfProductRepository_whenDeleteProductIsCalled() throws Exception {
       // Arrange
       doNothing().when(placeRepository).delete(place);
       PlacesRepository my = Mockito.mock(PlacesRepository.class);
       // Act
       placeDbServiceImpl.delete(place);
       // Assert
       verify(placeRepository, times(1)).delete(place);
   }
}