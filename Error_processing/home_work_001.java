package Error_processing;

public class home_work_001 {

    public static void main(String[] args) {
        // task1(); //
        // task2(); //
        // task3(); //
        // task4(); //
    }

    static void task1() {
        try {
            int[] res = getDivideArray(new int[] { -6, 0, 9, 6 }, new int[] { 2, 2, 10, 0 });
            System.out.println("Частное элементов двух массивов (только целые числа)");
            for (int e : res) {
                System.out.printf("%d\t", e);
            }
        } finally {

        }
    }

    static int[] getDivideArray(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) {
            throw new RuntimeException("Оба массива должны существовать.");
        }

        if (arr1.length != arr2.length) {
            throw new RuntimeException(
                    String.format("Кол-во элементов массива должно быть одинаково.", arr1.length, arr2.length));
        }

        int[] res = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            if (arr2[i] == 0)
                throw new RuntimeException(
                        String.format(
                                "\n\nДелить на ноль нельзя!!!\nНоль в массиве 2, находится под индексом №: [%d]\n", i));
            res[i] = arr1[i] / arr2[i];
        }
        return res;

    }
}
