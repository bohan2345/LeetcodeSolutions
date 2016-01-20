/**
 * Given an array of integers, find two numbers such that they add up to a
 * specific target number. <br>The function twoSum should return indices of the two
 * numbers such that they add up to the target, where index1 must be less than
 * index2. Please note that your returned answers (both index1 and index2) are
 * not zero-based. <br>You may assume that each input would have exactly one
 * solution.<br>
 * For reference, look here: <a href="https://leetcode.com/problems/two-sum/">leetcode</a>
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    var table = {};
    var result = [];
    nums.forEach(function(value, index, array) {
        if ((target - value) in table) {
            result[0] = table[target - value];
            result[1] = index + 1;
        }
        table[value] = index + 1;
    });
    return result;
};