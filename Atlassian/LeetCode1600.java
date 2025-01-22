class ThroneInheritance {
    HashMap<String,ArrayList<String>> map;
    Set<String> death;
    String king = "";
    public ThroneInheritance(String kingName) {
        map = new HashMap<>();
        death = new HashSet<>();
        king = kingName;
    }
    
    public void birth(String parentName, String childName) {
        if(!map.containsKey(parentName)){
            ArrayList<String> arr = new ArrayList<>();
            arr.add(childName);
            map.put(parentName,arr);
        }else{
            ArrayList<String> arr = map.get(parentName);
            arr.add(childName);
            map.put(parentName,arr);
        }
    }
    
    public void death(String name) {
        death.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        ArrayList<String> result=new ArrayList<String>();
        Stack<String> stck=new Stack<String>();
        stck.add(king);
        while(stck.size()>0)
        {
            String s=stck.pop();
            if(!death.contains(s))
            {
                result.add(s);
            }
            if(map.containsKey(s))
            {
                ArrayList<String> l=map.get(s);
                for(int j=l.size()-1;j>=0;j--)
                {
                    stck.push(l.get(j));
                }
            }
        }

        return result;
    }
}

