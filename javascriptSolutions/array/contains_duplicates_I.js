/**
 * 
 * @param {number[]} nums
 * @return {boolean}
 */
var containsDuplicate = function(nums) {
    var table = {};
    var result = false;
    nums.forEach(function(value, index) {
        if (table[value]) {
            result = true;
        }
        table[value] = true;
    });
    return result;
};