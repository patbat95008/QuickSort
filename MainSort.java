import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class MainSort {

	public static void printArray(int[] array){
		for(int i = 0; i < array.length; i++){
			System.out.printf("%d ", array[i]);
		}
		
		System.out.println('\n');
	}
	
	public static void main(String[] args) {
		// Generate an array of user defined size with random integers to sort
		int max = 10, min = 0;
		
		//int range = (max - min) + 1;
		
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the size of the random array: ");
		
		int inNum = reader.nextInt();
		reader.close();
		
		int[] mainArray = new int[inNum];
		
		for(int i = 0; i < inNum; i++){
			mainArray[i] = ThreadLocalRandom.current().nextInt(min, max+1);
		}

		printArray(mainArray);
		
		quicksort(mainArray, 0, mainArray.length - 1);
		
		printArray(mainArray);
		
	}
	
	public static void quicksort(int[] array, int low, int high){
		if(low < high){
			printArray(array);
			int p = partition(array, low, high);
			quicksort(array, low, p - 1);
			quicksort(array, p + 1, high);
		}
	}
	
	public static int partition(int[] array, int low, int high){
		int pivot = array[high];
		int i = low;
		
		for(int j = low; j < high; j++){
			if(array[j] <= pivot){
				swap(array, i, j);
				i++;
			}
			
		}
		swap(array, i, high);
		return i;
	}
	
	public static void swap(int[] array, int i, int j){
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

}
