import math
class Solution:
    # @param A : list of integers
    # @param B : list of integers
    # @return an integer
    @staticmethod
    def coverPoints(A, B):
        i = 0
        j = 0 
        weight = 0
        for i in range(0, len(A) - 1):
            j = i+1
            weight += max(abs(A[i] - A[j]), abs(B[i] - B[j]))

        return weight

weight = Solution.coverPoints([4, 8, -7, -5, -13, 9, -7, 8], [4, -15, -10, -3, -13, 12, 8, -8])
print weight
