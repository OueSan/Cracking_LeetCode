class Solution:
	def reachNumber(self, target: int) -> int:
		queue = [0]
		step = 1

		while queue:
			curr_level = len(queue)
			for i in range(curr_level):
				current = queue.pop(0)
				go_left = current - step
				go_right = current + step
				
				if go_left == target or go_right == target:
					return step
				
				queue += [go_left, go_right]
			step += 1
		
		return -1