package mela.test.model;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import mela.model.LocationManager;

public class TestLocationManager {

	@Test
	public void testGridOneCreation() {
		int n = 10;
		LocationManager grid1 = LocationManager.buildGridOne( n );
		assertNotNull(grid1);
		assertEquals(10,grid1.size());
	}
	
	@Test
	public void testGridOneNeighbourhoods() {
		int n = 10;
		LocationManager grid1 = LocationManager.buildGridOne( 10 );
		for (int i=0 ; i<n ; i++ ) {
			for (int j=0 ; j<n ; j++ ) {
				assertEquals( i+"->"+j, (Math.abs(i-j)==1) , grid1.edge(i, j) );
			}
		}
	}
	
	@Test
	public void testGridOneDistance() {
		int n = 10;
		LocationManager grid1 = LocationManager.buildGridOne( 10 );
		for (int i=0 ; i<n ; i++ ) {
			for (int j=0 ; j<n ; j++ ) {
				assertEquals( i+"->"+j, Math.abs(j-i) , grid1.getDistance(i, j) );
			}
		}
	}
	
	@Test
	public void testGridOnePeriodicNeighbourhoods() {
		int n = 10;
		LocationManager grid1 = LocationManager.buildGridOne( 10 , true );
		for (int i=0 ; i<n ; i++ ) {
			for (int j=0 ; j<n ; j++ ) {
				assertEquals( i+"->"+j, (Math.abs(i-j)==1)||(Math.abs(i-j)==n-1) , grid1.edge(i, j) );
			}
		}
	}
	
	@Test
	public void testGridOnePeriodicDistance() {
		int n = 10;
		LocationManager grid1 = LocationManager.buildGridOne( 10 , true );
		for (int i=0 ; i<n ; i++ ) {
			for (int j=0 ; j<n ; j++ ) {
				assertEquals( i+"->"+j, Math.min(Math.abs(j-i),Math.min((n-i+j)%n, (n-j+i)%n)) , grid1.getDistance(i, j) );
			}
		}
	}
	
	@Test
	public void testGridTwoNeighbourhoods() {
		int width = 5;
		int height = 5;
		LocationManager grid2 = LocationManager.buildGridTwo( height , width , true );
		for (int i1=0 ; i1<width ; i1++ ) {
			for (int j1=0 ; j1<height ; j1++ ) {
				for( int i2=0 ; i2<width ; i2++ ) {					
					for( int j2=0 ; j2<height ; j2++ ) {
						String l1 = LocationManager.locationName(i1, j1);
						String l2 = LocationManager.locationName(i2, j2);
						assertEquals( 
							l1+"->"+l2 ,
							((Math.abs(i1-i2)==1)&&(j1==j2))||((i1==i2)&&(Math.abs(j1-j2)==1)) , 
							grid2.edge(l1, l2)
						);
					}					
				}								
			}
		}
	}
   

}
