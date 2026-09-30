// Instrumented copies of the Workbench's algorithms: the same code plus prints of the array after
// each pass, the counts, and each index a search checks. Real Java checks these (sorting-cases.json),
// and run-sorting-tests.mjs checks that the Workbench reads the same facts from the plain code.
const ROW = '        for (int x : arr) {\n            System.out.print(x + " ");\n        }\n        System.out.println();\n';
const CODE = {
  linear: 'static int linearSearch(int[] arr, int target) {\n    for (int i = 0; i < arr.length; i++) {\n        System.out.print(i + " ");\n        if (arr[i] == target) {\n            return i;\n        }\n    }\n    return -1;\n}',
  binary: 'static int binarySearch(int[] arr, int target) {\n    int low = 0;\n    int high = arr.length - 1;\n    while (low <= high) {\n        int mid = (low + high) / 2;\n        System.out.print(mid + " ");\n        if (arr[mid] == target) {\n            return mid;\n        } else if (arr[mid] < target) {\n            low = mid + 1;\n        } else {\n            high = mid - 1;\n        }\n    }\n    return -1;\n}',
  selection: 'static void selectionSort(int[] arr) {\n    int comparisons = 0;\n    int swaps = 0;\n    for (int i = 0; i < arr.length - 1; i++) {\n        int minIndex = i;\n        for (int j = i + 1; j < arr.length; j++) {\n            comparisons++;\n            if (arr[j] < arr[minIndex]) {\n                minIndex = j;\n            }\n        }\n        int temp = arr[i];\n        arr[i] = arr[minIndex];\n        arr[minIndex] = temp;\n        swaps++;\n' + ROW + '    }\n    System.out.println("comparisons " + comparisons + " swaps " + swaps + " shifts 0");\n}',
  insertion: 'static boolean greater(int x, int y, int[] count) {\n    count[0]++;\n    return x > y;\n}\n\nstatic void insertionSort(int[] arr) {\n    int[] count = new int[1];\n    int shifts = 0;\n    for (int i = 1; i < arr.length; i++) {\n        int key = arr[i];\n        int j = i - 1;\n        while (j >= 0 && greater(arr[j], key, count)) {\n            arr[j + 1] = arr[j];\n            shifts++;\n            j--;\n        }\n        arr[j + 1] = key;\n' + ROW + '    }\n    System.out.println("comparisons " + count[0] + " swaps 0 shifts " + shifts);\n}',
};
const METHOD = { linear: 'linearSearch', binary: 'binarySearch', selection: 'selectionSort', insertion: 'insertionSort' };
export function instrumented(algo, data, target) {
  const search = algo === 'linear' || algo === 'binary';
  return `${CODE[algo]}\n\nint[] data = {${data.join(', ')}};\n` + (search ? `int r = ${METHOD[algo]}(data, ${target});\nSystem.out.println();\nSystem.out.println(r);` : `${METHOD[algo]}(data);`);
}
// What the instrumented output says: pass rows and counts for a sort, checked indexes and result for a search.
export function readInstrumented(algo, out) {
  const lines = out.trim().split('\n');
  if (algo === 'linear' || algo === 'binary') return { checked: lines.length > 1 ? lines[0].trim().split(' ').filter(Boolean).map(Number) : [], result: lines[lines.length - 1].trim() };
  const m = lines[lines.length - 1].match(/comparisons (\d+) swaps (\d+) shifts (\d+)/);
  return { passes: lines.slice(0, -1).map(l => l.trim().split(' ').map(Number)), comparisons: +m[1], swaps: +m[2], shifts: +m[3] };
}
