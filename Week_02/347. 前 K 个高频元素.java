class Solution {
    public int[] topKFrequent(int[] nums, int k) {
HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (int key:map.keySet()) {
            if(queue.size()<k){
                queue.add(key);
            }else if(map.get(key)>map.get(queue.peek())){
                queue.remove();
                queue.add(key);
            }
        }
        int[] result = new int[k];
        int i = 0;
        while (!queue.isEmpty()){
            result[i] =  queue.remove();
            i++;
        }
        return result;
    }
}