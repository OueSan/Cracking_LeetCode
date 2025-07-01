func longestZigZag(root *TreeNode) int {
    res := 0
    
    var walk func(*TreeNode, int, int)
    walk = func(root* TreeNode, l, r int) {
        if root != nil {
            res = max(res, l, r)
            walk(root.Left, r + 1, 0)
            walk(root.Right, 0, l + 1)
        }
    }
    
    walk(root, 0, 0)
    return res
}

func max(a ...int) int {
    res := a[0]
    for _, v := range a {
        if v > res {
            res = v
        }
    }
    return res
}