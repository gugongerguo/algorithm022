class Solution {
    public int[] findTopKQuery(int[][] orders, int k) {
      int[] result = new int[0];
        Map<Integer,int[]> cronTab = new HashMap<Integer,int[]>();//定时器
        Map<Integer,int[]> items = new HashMap<Integer,int[]>();//任务对象
        for (int[] order:orders) {
            int id = order[0];
            int first = order[1];
            int interval = order[2];
            items.put(id, order);
            addCronTab(cronTab,id,first);
        }
        int i = 0;
        while (result.length < k) {
            ++i;
            if (cronTab.containsKey(i)) {
                int[] ids = cronTab.get(i);
                for (int id:ids) {
                    result = Arrays.copyOf(result, result.length+1);
                    result[result.length-1]= id;
                    if(result.length>=k){
                       return result; 
                    }
                    addCronTab(cronTab,id,i+items.get(id)[2]);
                }
                cronTab.remove(i);
            }
        }
      return result;
    }

    private void addCronTab (Map<Integer,int[]> cronTab,int id,int time) {
        if (!cronTab.containsKey(time)) {
            cronTab.put(time, new int[]{id});
        }else{
            int[] ids = cronTab.get(time);
            ids = Arrays.copyOf(ids, ids.length+1);
            ids[ids.length-1] = id;
            Arrays.sort(ids);
            cronTab.put(time, ids);
        }
    }
}