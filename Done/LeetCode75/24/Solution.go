func equalPairs(grid [][]int) int {
	rows := make(map[string]int)
	cols := make(map[string]int)
	rowBuf := make([]byte, len(grid)*4)
	colBuf := make([]byte, len(grid)*4)
	for i := range grid {
		for j := range grid[i] {
			binary.BigEndian.PutUint32(rowBuf[j*4:], uint32(grid[i][j]))
			binary.BigEndian.PutUint32(colBuf[j*4:], uint32(grid[j][i]))
		}
		rows[string(rowBuf)]++
		cols[string(colBuf)]++
	}

	count := 0
	for k := range cols {
		count += rows[k] * cols[k]
	}

	return count
}