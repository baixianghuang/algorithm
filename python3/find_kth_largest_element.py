class Solution:
    def partition(self, ori_list, start, end):
        i = start
        j = end  # must firstly move j
        pivot = ori_list[start]

        while i != j:
            # print('i, j: ', i, j, l[j] < pivot and l[i] > pivot)
            while ori_list[j] >= pivot and i < j:  # j must move first
                j -= 1
            while ori_list[i] <= pivot and i < j:
                i += 1

            if i < j:
                ori_list[i], ori_list[j] = ori_list[j], ori_list[i]

        ori_list[i], ori_list[start] = ori_list[start], ori_list[i]
        # print(ori_list, j)
        return j
    
    def findKthLargest(self, nums, k):
        """c"""
        if k < 0 or k > len(nums) or nums == None:
            return False
        
        left = 0
        right = len(nums) - 1
        index = self.partition(nums, left, right)
        while index != len(nums) - k:
            if len(nums) - k > index:
                index = self.partition(nums, index+1, right)
            elif len(nums) - k < index:
                index = self.partition(nums, left, index-1)
#        print(nums[index])
        return nums[index]
        
s = Solution()        
#print(s.partition([3,4,2,1,5,6], 0, 5))
print(s.findKthLargest([3,2,1,5,6,4], 1))
