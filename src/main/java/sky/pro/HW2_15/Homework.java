package sky.pro.HW2_15;

import sky.pro.HW2_15.Exceptions.NotFoundException;
import sky.pro.HW2_15.Exceptions.NullException;
import sky.pro.HW2_15.Exceptions.OutOfSizeException;

public class Homework implements IntegerList {


    private Integer[] ar;
    private int arSize = 0;

    public Homework(int i) {
        ar = new Integer[i];
        for (int j = 0; j < i; j++) {
            ar[j] = 0;
        }
    }


    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < arSize; i++) {
            result += "[" + ar[i] + "] ";
        }
        return result;
    }

    @Override
    public Integer add(Integer item) {
        if (item == null) {
            throw new NullException("Аргумент не должен быть null");
        }
        for (int i = 0; i < ar.length; i++) {
            if ((ar[i]).equals(0)) {
                ar[i] = item;
                arSize++;
                return item;
            } else {
                continue;
            }
        }
        System.out.println("Массив заполнен");
        return null;
    }

    @Override
    public Integer add(int index, Integer item) {
        if (ar.length == arSize) {
            throw new OutOfSizeException("Массив заполнен");
        }
        if (index > arSize) {
            throw new OutOfSizeException("Индекс не должен быть больше количества элементов");
        }

        for (int i = arSize; i > index; i--) {
            ar[i] = ar[i - 1];

        }
        ar[index] = item;
        arSize++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        if (index > arSize) {
            throw new OutOfSizeException("Индекс не должен быть больше количества элементов");
        }
        ar[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        for (int i = 0; i < ar.length; i++) {
            if ((ar[i]) == (item)) {
                for (int j = i; j < arSize; j++) {
                    ar[j] = ar[j + 1];
                }
                arSize--;
                break;
            }
            if (i == arSize) {
                throw new NotFoundException("Не удалось найти элемент");
            }
        }
        return item;
    }

    @Override
    public Integer remove(int index) {
        if (index > arSize - 1) {
            throw new OutOfSizeException("Индекс не найден");
        }
        Integer result = ar[index];
        for (int i = index; i < arSize; i++) {
            ar[i] = ar[i + 1];
        }
        arSize--;
        return result;
    }


    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < arSize; i++) {
            if ((ar[i]) == (item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = arSize; i > -1; i--) {
            if ((ar[i]).equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        if (index > arSize - 1) {
            throw new OutOfSizeException("Индекс не найден");
        }
        return ar[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (this.arSize == otherList.size()) {
            for (int i = 0; i < this.arSize; i++) {
                if ((this.ar[i]).equals(otherList.get(i))) {
                    continue;
                } else {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return arSize;
    }

    @Override
    public boolean isEmpty() {
        if (arSize == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < arSize; i++) {
            ar[i] = 0;
        }
        arSize = 0;
    }

    @Override
    public int[] toArray() {
        int[] ar2 = new int[arSize];
        for (int i = 0; i < arSize; i++) {
            ar2[i] = ar[i];
        }
        return ar2;
    }

    public Integer[] rndFill() {
        for (int i = 0; i < 100_000; i++) {
            ar[i] = ((int) (Math.random() * (100_000) + 1));
            arSize++;
        }
        return ar;
    }

    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

//    public static void sortInsertion(int[] arr) {
//        for (int i = 1; i < arr.length; i++) {
//            int temp = arr[i];
//            int j = i;
//            while (j > 0 && arr[j - 1] >= temp) {
//                arr[j] = arr[j - 1];
//                j--;
//            }
//            arr[j] = temp;
//        }
//    }

    //    @Override
//    public boolean contains(Integer item) {
//        for (Integer s : ar) {
//            if (s==(item)) {
//                return true;
//            }
//
//        }
//        return false;
//    }
    @Override
    public boolean contains(int[] arr, int element) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (element == arr[mid]) {
                return true;
            }

            if (element < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
}
