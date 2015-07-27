/**
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