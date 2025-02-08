/**
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
var reduce = function(nums, fn, init) {
  if(nums.length === 0) return init;
 let i =0;
 let value = init;
 while(i<nums.length){

     value = fn(value, nums[i]);
     i++;
 }


return value;
};