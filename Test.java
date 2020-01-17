给定一个整数数组，判断是否存在重复元素。
如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都
不相同，则返回 false。
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;
    }
}

你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。

你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/long-pressed-name
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        Queue<Character> q1=new LinkedList<>();
        Queue<Character> q2=new LinkedList<>();
        for(int i=0;i<name.length();i++){
            q1.offer(name.charAt(i));
        }
        for(int i=0;i<typed.length();i++){
            q2.offer(typed.charAt(i));
        }
        while(!q1.isEmpty()&&!q2.isEmpty()){
            if(q1.peek()==q2.peek()){
                q1.poll();
                q2.poll();
            }else{
                q2.poll();
            }
        }
        return q1.isEmpty();
    }
}


给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
class Solution {
    public int[] sortedSquares(int[] A) {
        for(int i=0;i<A.length;i++){
            A[i]=A[i]*A[i];
        }
         Arrays.sort(A);
        return A;
    }
}

给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
class Solution {
    public String reverseOnlyLetters(String S) {
        char[] arr=S.toCharArray();
        int left=0;
        int right=S.length()-1;
        while(left<right){
           boolean b1=((arr[left]>='A'&&arr[left]<='Z')||(arr[left]>='a'&&arr[left]<='z'));
           while(left<right&&!b1){
               left++;
               b1=((arr[left]>='A'&&arr[left]<='Z')||(arr[left]>='a'&&arr[left]<='z'));
           }
        boolean b2=((arr[right]>='A'&&arr[right]<='Z')|| (arr[right]>='a'&&arr[right]<='z'));
            while(left<right&&!b2){
                right--;
                b2=((arr[right]>='A'&&arr[right]<='Z')|| (arr[right]>='a'&&arr[right]<='z'));
            }
            if(left<right){
                char tmp=arr[left];
                arr[left++]=arr[right];
                arr[right--]=tmp;
            }
        }
        return new String(arr);
    }
}


给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。

你可以返回满足此条件的任何数组作为答案。
class Solution {
    public int[] sortArrayByParity(int[] A) {
        int l=0;
        int r=A.length-1;
        while(l<r){
            while(l<r&&A[l]%2==0){
                l++;
            }
            while(l<r&&A[r]%2==1){
                r--;
            }
            if(l<r){
                int tmp=A[l];
                A[l]=A[r];
                A[r]=tmp;
            }
        }
        return A;
    }
}


给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。

我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。

如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-pivot-index
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int pivotIndex(int[] nums) {
        if(nums.length==0){
            return -1;
        }
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        int tmp=0;
        for(int i=0;i<nums.length;i++){
            if(sum-nums[i]==2*tmp){
                return i;
            }
             tmp+=nums[i];
        }
        return -1;
    }
}

给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/plus-one
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int[] plusOne(int[] digits) {
        int carry=0;
        int len=digits.length-1;
        StringBuffer sb=new StringBuffer();
        int tmp=0;
        while(len>=0||carry!=0){
            if(len==digits.length-1){
                tmp=digits[len]+1+carry;
            }else if(len>=0&&len<digits.length-1){
                tmp=digits[len]+carry;
            }else{
                tmp=carry;
            }
            len--;
            carry=tmp/10;
            sb.append(tmp%10);
        }
        String s=new String(sb);
        int[] res=new int[s.length()];
        for(int i=0;i<res.length;i++){
            res[i]=s.charAt(res.length-i-1)-'0';
        }
        return res;
    }
}

给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
class Solution {
    public int thirdMax(int[] nums) {
        int max1=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max1=nums[i]>max1?nums[i]:max1;
        }
        int max2=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max2&&nums[i]!=max1){
                max2=nums[i];
            }
        }
        long max3=Long.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max3&&nums[i]!=max1&&nums[i]!=max2){
                max3=(int)nums[i];
            }
        }
        return nums.length>2&&max3!=Long.MIN_VALUE?(int)max3:max1;
    }
}

给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[] {i,j};
                }
            }
        }
        return new int[] {-1,-1};
    }
}

给定两个二进制字符串，返回他们的和（用二进制表示）。

输入为非空字符串且只包含数字 1 和 0。

class Solution {
    public String addBinary(String a, String b) {
        StringBuffer sb=new StringBuffer();
        int carry=0;
        int l1=a.length()-1;
        int l2=b.length()-1;
        while(l1>=0||l2>=0||carry!=0){
            int num1=l1>=0?a.charAt(l1--)-'0':0;
            int num2=l2>=0?b.charAt(l2--)-'0':0;
            int sum=num1+num2+carry;
            carry=sum/2;
            sb.append(sum%2);
        }
        return new String(sb.reverse());
    }
}

请你来实现一个 atoi 函数，使其能将字符串转换成整数。

首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。

当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。

该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。

注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。

在任何情况下，若函数不能进行有效的转换时，请返回 0。

说明：

假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/string-to-integer-atoi
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int myAtoi(String str) {
        String s=str.trim();
        if(s.equals("")){
            return 0;
        }
        int num=0;
        if(s.charAt(0)=='-'||s.charAt(0)=='+'){
            int i=1;
            while(i<s.length()&&s.charAt(i)>='0'&&s.charAt(i)<='9'){
                if(num>Integer.MAX_VALUE/10||(num==Integer.MAX_VALUE/10&&s.charAt(i)-'0'>8)){
                    return s.charAt(0)=='-'?Integer.MIN_VALUE:Integer.MAX_VALUE;
                }
                num=num*10+s.charAt(i)-'0';
                i++;
            }
            return s.charAt(0)=='-'?-num:num;
        }else if(s.charAt(0)>='0'&&s.charAt(0)<='9'){
            int i=0;
            while(i<s.length()&&s.charAt(i)>='0'&&s.charAt(i)<='9'){
                if(num>Integer.MAX_VALUE/10||(num==Integer.MAX_VALUE/10&&s.charAt(i)-'0'>7)){
                    return Integer.MAX_VALUE;
                }
                num=num*10+s.charAt(i)-'0';
                i++;
            }
            return num;
        }
        return 0;

    }
}

给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 O(log n) 级别。

如果数组中不存在目标值，返回 [-1, -1]。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res={-1,-1};
        int l=0;
        int r=nums.length-1;
        while(l<=r){
            int mid=(l+r)>>>1;
            if(nums[mid]<target){
                l=mid+1;
                if(nums[r]>target){
                    r--;
                }
            }else if(nums[mid]>target){
                r=mid-1;
                if(nums[l]<target){
                    l++;
                }
            }else{
                if(nums[l]<target){
                    l++;
                }if(nums[r]>target){
                    r--;
                }
            }
            if(l>=nums.length||r<0){
                return res;
            }if(nums[l]==target&&nums[r]==target){
                res[0]=l;
                res[1]=r;
                return res;
            }
        }
        return res;
    }
}