class Solution:
    def isValid(self, s: str) -> bool:
        valid_def = {'(': ')', '[': ']', '{': '}'}

        check_stack = []
        for item in s:
            if valid_def.get(item):
                check_stack.append(item)
            else:
                if not check_stack:
                    return False
                if valid_def.get(check_stack.pop()) != item:
                    return False
        else:
            if check_stack:
                return False
        return True


if __name__ == '__main__':
    test = Solution()

    print(test.isValid("()"))
    print(test.isValid(")("))
    print(test.isValid("()[]{}"))
    print(test.isValid("(]"))
    print(test.isValid("([)]"))
    print(test.isValid("{[]}"))
    print(test.isValid("(])"))
