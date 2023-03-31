def heap(arr, n, i):
    l = i
    left = 2 * i + 1
    right = 2 * i + 2

    if left < n and arr[left] > arr[l]:
        l = left

    if right < n and arr[right] > arr[l]:
        l = right

    if l != i:
        arr[i], arr[l] = arr[l], arr[i]
        heap(arr, n, l)

def heap_sort(arr):
    n = len(arr)

    
    for i in range(n // 2 - 1, -1, -1):
        heap(arr, n, i)

    
    for i in range(n - 1, 0, -1):
        arr[0], arr[i] = arr[i], arr[0]
        heap(arr, i, 0)

    return arr


arr = [12, 6, 13, -2, 6, 7, 0]
print(arr)
sorted_arr = heap_sort(arr)
print(sorted_arr)
