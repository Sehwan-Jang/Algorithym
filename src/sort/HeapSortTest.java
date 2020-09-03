package sort;

public class HeapSortTest {

	public static boolean hasChild(int[] arr, int index, int length) {
		if (length - 1 >= 2 * index + 1) {
			return true;
		}
		return false;
	}

	public static void max_Heapify(int[] arr, int index, int length) {
		while (hasChild(arr, index, length)) {
			int k;
			if (length - 1 >= index * 2 + 2) {
				k = (arr[2 * index + 1] > arr[2 * index + 2]) ? 2 * index + 1 : 2 * index + 2;
			} else {
				k = index * 2 + 1;
			}

			if (arr[index] >= arr[k]) {
				return;
			}
			int tmp = arr[index];
			arr[index] = arr[k];
			arr[k] = tmp;
			index = k;
		}
	}

	public static void buildMaxHeap(int[] arr) {
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			max_Heapify(arr, i, arr.length);
		}
	}

	public static void heapSort(int[] arr) {
		buildMaxHeap(arr);

		for (int i = arr.length - 1; i > 0; i--) {
			int tmp = arr[0];
			arr[0] = arr[i];
			arr[i] = tmp;

			max_Heapify(arr, 0, i);
		}
	}

	public static void main(String[] args) {

		int[] arr = { 230, 10, 60, 550, 40, 220, 20 };
		heapSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "  ");
		}
	}

}
