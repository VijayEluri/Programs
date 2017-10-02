class Solution:
    # @param A : list of integers
    # @return a list of integers
    def plusOne(self, A):
        num_elements = len(A)
        if num_elements == 0:
            return [1]

        new_number = []
        first_element = A[len(A) - 1]
        carry_over = False
        if first_element == 9:
            carry_over = True
            new_number.append(0)        
        else:
            new_number.append(first_element + 1)

        for i in range(len(A) - 2, -1, -1):
            present_digit = A[i]
            if carry_over:
                if present_digit == 9:
                    new_number.append(0)
                else:
                    new_number.append(present_digit+1)
                    carry_over = False
            else:
                new_number.append(present_digit)
        
        if carry_over:
            new_number.append(1)

        return reversed(new_number)