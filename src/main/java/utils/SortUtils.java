package utils;

import java.util.*;

/**
 * 排序工具类
 * <p>
 * 尽量保证方法可以独立运行，所以一些方法没有抽象出来。
 * <p>
 * JDK11
 *
 * @author ：zhaochdev ( zhaoch.dev @ outlook . com )
 */
public class SortUtils {
    /**
     * 插入排序（Insertion Sort）是一种简单直观的排序算法。它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
     * 插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
     * <p>
     * 类似打牌时，将手中的牌从小到大排序。
     * <p>
     * 时间复杂度：
     * 最佳：T(n) = O(n)，最坏：T(n) = O(n²)，平均：T(n) = O(n²)
     *
     * @param array int数组
     */
    public static void insertionSort(int[] array) {
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
    }

    /**
     * 插入排序（Insertion Sort）
     * <p>
     * 对象数组其他排序方法类似，不再实现。
     *
     * @param array 对象数组
     */
    public static <T extends Comparable<T>> void insertionSort(T[] array) {
        T current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current.compareTo(array[preIndex]) < 0) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
    }

    /**
     * 冒泡排序（Bubble Sort）是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来。
     * 走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
     * <p>
     * 冒泡排序对n个项目需要O(n²)的比较次数，且可以原地排序。尽管这个算法是最简单了解和实现的排序算法之一，但它对于包含大量的元素的数列排序是很没有效率的。
     * <p>
     * 冒泡排序是与插入排序拥有相等的运行时间，但是两种算法在需要的交换次数却很大地不同。在最坏的情况，冒泡排序需要O(n²)次交换，而插入排序只要最多O(n)交换。
     * 冒泡排序的实现通常会对已经排序好的数列拙劣地运行（O(n²)），而插入排序可能只需要O(n)个运算。因此很多现代的算法教科书避免使用冒泡排序，而用插入排序取代之。
     * 冒泡排序如果能在内部循环第一次运行时，使用一个旗标来表示有无需要交换的可能，也可以把最优情况下的复杂度降低到O(n)。在这个情况，已经排序好的数列就无交换的需要。
     * 若在每次走访数列时，把走访顺序反过来，也可以稍微地改进效率。有时候称为鸡尾酒排序，因为算法会从数列的一端到另一端之间穿梭往返。
     * <p>
     * 时间复杂度：
     * 最佳：T(n) = O(n)，最差：T(n) = O(n²)，平均：T(n) = O(n²)
     *
     * @param array int数组
     */
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    /**
     * 选择排序（Selection Sort）是一种简单直观的排序算法。它的工作原理如下。首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置。
     * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
     * <p>
     * 选择排序的主要优点与数据移动有关。如果某个元素位于正确的最终位置上，那么它不会被移动。
     * 选择排序每次交换一对元素，它们当中至少有一个将被移到其最终位置上，因此对n个元素的表进行排序总共进行至多n-1次交换。
     * 在所有的完全依靠交换去移动元素的排序方法中，选择排序属于非常好的一种。
     * <p>
     * 时间复杂度：
     * 最佳：T(n) = O(n²)，最差：T(n) = O(n²)，平均：T(n) = O(n²)
     *
     * @param array int数组
     */
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    /**
     * 希尔排序（Shell Sort），也称递减增量排序算法，是插入排序的一种更高效的改进版本。希尔排序是非稳定排序算法。
     * 希尔排序是基于插入排序的以下两点性质而提出改进方法的：1.插入排序在对几乎已经排好序的数据操作时，效率高，即可以达到线性排序的效率；2.但插入排序一般来说是低效的，因为插入排序每次只能将数据移动一位。
     * <p>
     * 时间复杂度：
     * 最佳：T(n) = O(nlog²n)，最坏：T(n) = O(nlog²n)，平均：T(n) = O(nlog²n)
     *
     * @param array int数组
     */
    public static void ShellSort(int[] array) {
        int temp, gap = array.length / 2;
        while (gap > 0) {
            for (int i = gap; i < array.length; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
    }

    /**
     * 快速排序（Quick Sort），又称划分交换排序（partition-exchange sort）。
     * 在平均状况下，排序n个项目要O(nlogn)次比较。在最坏状况下则需要O(n²)次比较，但这种状况并不常见。
     * 快速排序O(nlogn)通常明显比其他算法更快，因为它的内部循环可以在大部分的架构上很有效率地达成。
     * <p>
     * 时间复杂度：
     * 最佳：T(n) = O(nlogn)，最差：T(n) = O(n²)，平均：T(n) = O(nlogn)
     *
     * @param array     int数组
     * @param headIndex 起始位置
     * @param tailIndex 结束位置
     */
    public static void quickSort(int[] array, int headIndex, int tailIndex) {
        if (headIndex >= tailIndex || array == null || array.length <= 1) {
            return;
        }
        int i = headIndex, j = tailIndex, middle = array[(headIndex + tailIndex) / 2];
        while (i <= j) {
            while (array[i] < middle) {
                ++i;
            }
            while (array[j] > middle) {
                --j;
            }
            if (i < j) {
                int t = array[i];
                array[i] = array[j];
                array[j] = t;
                ++i;
                --j;
            } else if (i == j) {
                ++i;
            }
        }
        quickSort(array, headIndex, j);
        quickSort(array, i, tailIndex);
    }

    /**
     * 归并排序（Merge Sort）是建立在归并操作上的一种有效的排序算法，该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
     * 将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为二路归并。归并排序是一种稳定的排序方法。
     * <p>
     * 分治法:
     * 1.分割：递归地把当前序列平均分割成两半。
     * 2.集成：在保持元素顺序的同时将上一步得到的子序列集成到一起（归并）。
     * <p>
     * 时间复杂度：
     * 最佳：T(n) = O(n)，最差：T(n) = O(nlogn)，平均：T(n) = O(nlogn)
     *
     * @param array      int数组
     * @param leftIndex  起始位置
     * @param rightIndex 结束位置
     * @return 已排序的int数组
     */
    public static int[] mergeSort(int[] array, int leftIndex, int rightIndex) {
        if (leftIndex == rightIndex) {
            return array;
        }
        int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
        // 左侧排序
        mergeSort(array, leftIndex, middleIndex);
        // 右侧排序
        mergeSort(array, middleIndex + 1, rightIndex);
        // 合并
        int[] tempArray = new int[array.length];
        int leftPoint = leftIndex, rightPoint = middleIndex + 1, nowPoint = leftIndex;
        while (leftPoint <= middleIndex && rightPoint <= rightIndex) {
            if (array[leftPoint] <= array[rightPoint]) {
                tempArray[nowPoint++] = array[leftPoint++];
            } else {
                tempArray[nowPoint++] = array[rightPoint++];
            }
        }
        //如果序列未排序完，直接合并
        while (leftPoint <= middleIndex) {
            tempArray[nowPoint++] = array[leftPoint++];
        }
        while (rightPoint <= rightIndex) {
            tempArray[nowPoint++] = array[rightPoint++];
        }
        // 复制至原数组
        if (rightIndex + 1 - leftIndex >= 0) {
            System.arraycopy(tempArray, leftIndex, array, leftIndex, rightIndex + 1 - leftIndex);
        }
        return array;
    }

    /**
     * 堆排序（Heap Sort）是指利用堆这种数据结构所设计的一种排序算法。
     * 堆是一个近似完全二叉树的结构，并同时满足堆积的性质：即子节点的键值或索引总是小于（或者大于）它的父节点。
     * <p>
     * 时间复杂度：
     * 最佳：T(n) = O(nlogn)，最差：T(n) = O(nlogn)，平均：T(n) = O(nlogn)
     *
     * @param array int数组
     */
    public static void heapSort(int[] array) {
        /*
         *  第一步：将数组堆化
         *  beginIndex = 第一个非叶子节点。
         *  从第一个非叶子节点开始即可。无需从最后一个叶子节点开始。
         *  叶子节点可以看作已符合堆要求的节点，根节点就是它自己且自己以下值为最大。
         */
        int len = array.length - 1;
        int beginIndex = (array.length >> 1) - 1;
        for (int i = beginIndex; i >= 0; i--) {
            maxHeapify(array, i, len);
        }
        /*
         * 第二步：对堆化数据排序
         * 每次都是移出最顶层的根节点A[0]，与最尾部节点位置调换，同时遍历长度 - 1。
         * 然后从新整理被换到根节点的末尾元素，使其符合堆的特性。
         * 直至未排序的堆长度为 0。
         */
        for (int i = len; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            maxHeapify(array, 0, i - 1);
        }
    }

    /**
     * 调整索引为 index 处的数据，使其符合堆的特性。
     *
     * @param index  需要堆化处理的数据的索引
     * @param length 未排序的堆（数组）的长度
     */
    private static void maxHeapify(int[] array, int index, int length) {
        // 左子节点索引
        int leftIndex = (index << 1) + 1;
        // 右子节点索引
        int rightIndex = leftIndex + 1;
        // 子节点值最大索引，默认左子节点。
        int maxIndex = leftIndex;
        // 左子节点索引超出计算范围，直接返回。
        if (leftIndex > length) {
            return;
        }
        // 先判断左右子节点，哪个较大。
        if (rightIndex <= length && array[rightIndex] > array[leftIndex]) {
            maxIndex = rightIndex;
        }
        // 如果父节点被子节点调换，则需要继续判断换下后的父节点是否符合堆的特性。
        if (array[maxIndex] > array[index]) {
            int temp = array[maxIndex];
            array[maxIndex] = array[index];
            array[index] = temp;
            maxHeapify(array, maxIndex, length);
        }
    }

    /**
     * 计数排序（Counting Sort）是一种稳定的线性时间排序算法。该算法于1954年由 Harold H. Seward 提出。
     * 计数排序使用一个额外的数组C ，其中第i个元素是待排序数组A中值等于i的元素的个数。然后根据数组C来将A中的元素排到正确的位置。
     * <p>
     * 时间复杂度：
     * 最佳：T(n) = O(n+k)，最差：T(n) = O(n+k)，平均：T(n) = O(n+k)
     *
     * @param array int数组
     */
    public static void CountingSort(int[] array) {
        if (array.length == 0) {
            return;
        }
        int bias, min = array[0], max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        bias = -min;
        int[] bucket = new int[max - min + 1];
        Arrays.fill(bucket, 0);
        for (int value : array) {
            bucket[value + bias]++;
        }
        int index = 0, i = 0;
        while (index < array.length) {
            if (bucket[i] != 0) {
                array[index] = i - bias;
                bucket[i]--;
                index++;
            } else {
                i++;
            }
        }
    }

    /**
     * 桶排序（Bucket Sort）或所谓的箱排序，是一个排序算法，工作的原理是将数组分到有限数量的桶里，每个桶再个别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排序）。
     * 桶排序是鸽巢排序的一种归纳结果。当要被排序的数组内的数值是均匀分配的时候，桶排序使用线性时间O(n)。但桶排序并不是比较排序，他不受到O(nlogn)下限的影响。
     * <p>
     * 桶排序以下列程序进行：
     * 1.设置一个定量的数组当作空桶子。
     * 2.寻访序列，并且把项目一个一个放到对应的桶子去。
     * 3.对每个不是空的桶子进行排序。
     * 4.从不是空的桶子里把项目再放回原来的序列中。
     * <p>
     * 时间复杂度：
     * 最佳：T(n) = O(n)，最差：T(n) = O(n²)，平均：O(n+c)，其中c=n*(logn-logm)、n待排数据、m桶数
     *
     * @param array int数组
     */
    public static void BucketSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int max = Integer.MIN_VALUE;
        for (int value : array) {
            max = Math.max(max, value);
        }

        int[] bucket = new int[max + 1];

        for (int value : array) {
            bucket[value]++;
        }

        for (int i = 0, j = 0; j < bucket.length; j++) {
            while (bucket[j]-- > 0) {
                array[i++] = j;
            }
        }
    }

    /**
     * 我们选择插入排序作为桶内元素排序的方法 每当有一个新元素到来时，我们都调用该方法将其插入到恰当的位置
     */
    private static void insertSort(List<Integer> bucket, int data) {
        ListIterator<Integer> it = bucket.listIterator();
        boolean insertFlag = true;
        while (it.hasNext()) {
            if (data <= it.next()) {
                it.previous(); // 把迭代器的位置偏移回上一个位置
                it.add(data); // 把数据插入到迭代器的当前位置
                insertFlag = false;
                break;
            }
        }
        if (insertFlag) {
            bucket.add(data); // 否则把数据插入到链表末端
        }
    }

    /**
     * 基数排序（Radix Sort）是一种非比较型整数排序算法，其原理是将整数按位数切割成不同的数字，然后按每个位数分别比较。
     * 由于整数也可以表达字符串（比如名字或日期）和特定格式的浮点数，所以基数排序也不是只能使用于整数。
     * <p>
     * 基数排序的方式可以采用LSD（Least significant digital）或MSD（Most significant digital），LSD的排序方式由键值的最右边开始，而MSD则相反，由键值的最左边开始。
     * <p>
     * 时间复杂度：
     * 最佳：T(n) = O(d(n+radix))，最差：T(n) = O(d(n+radix))，平均：T(n) = O(d(n+radix))
     *
     * @param array int数组
     */
    public static void RadixSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        int maxDigit = 0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        int mod = 10, div = 1;
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            bucketList.add(new ArrayList<>());
        }
        for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {
            for (int value : array) {
                int num = (value % mod) / div;
                bucketList.get(num).add(value);
            }
            int index = 0;
            for (ArrayList<Integer> integers : bucketList) {
                for (Integer integer : integers) {
                    array[index++] = integer;
                }
                integers.clear();
            }
        }
    }

}