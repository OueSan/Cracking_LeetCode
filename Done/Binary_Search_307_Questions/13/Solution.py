class Solution:
    def countNodes(self, root):
        if not root:
            return 0
        r = self.getD(root.left, True) + 1
        l = self.getD(root.right, False) + 1
        if r == l:
            return (1 << r) - 1
        return 1 + self.countNodes(root.left) + self.countNodes(root.right)

    def getD(self, node, left):
        d = 0
        while node:
            node = node.left if left else node.right
            d += 1
        return d