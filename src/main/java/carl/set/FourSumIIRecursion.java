package carl.set;

public class FourSumIIRecursion {
    
    private int res;
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        int sum = 0;
        int count = 1;
        tmp(sum,count,nums1, nums2, nums3, nums4);
        return res;

    }

    private void tmp( int sum, int count, int[] nums1, int[] nums2, int[] nums3, int[] nums4){
        if (count == 1){
            for (int j : nums1) {
                sum += j;
                tmp(sum, ++count, nums1, nums2, nums3, nums4);
                sum -= j;
                count--;
            }
        } else if (count == 2) {
            for (int j : nums2) {
                sum += j;
                tmp(sum, ++count, nums1, nums2, nums3, nums4);
                sum -= j;
                count--;
            }
        }else if (count == 3) {
            for (int j : nums3) {
                sum += j;
                tmp(sum, ++count, nums1, nums2, nums3, nums4);
                sum -= j;
                count--;
            }
        }else {
            for (int j : nums4) {
                if (sum+j == 0) {
                    res++;
                }
            }
        }

    }

    public static void main(String[] args) {
        new FourSumIIRecursion().fourSumCount(new int[]{-1,-1},new int[]{-1,1},new int[]{-1,1},new int[]{1,-1});
    }

}
