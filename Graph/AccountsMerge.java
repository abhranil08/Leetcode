class Node {
        Node parent;
        String email;
        int rank;
        String owner;
}

class Union{

    HashMap<String,Node> map = new HashMap<>();

    public void makeSet(String email, String owner)
    {
        Node node = new Node();
        node.parent = node;
        node.email = email;
        node.rank = 0;
        node.owner=owner;

        if(!map.containsKey(email))
        map.put(email,node);
    }

    public void union( String data1, String data2 )
    {
        Node parent1 = findSet(data1);
        Node parent2 = findSet(data2);

        /*if(parent1.equals.parent2)
            return;*/

        if( parent1.rank >= parent2.rank)
        {
            if(parent1.rank == parent2.rank)
            parent1.rank = parent1.rank+1;

            parent2.parent = parent1;
        }
        else
        {
            parent1.parent = parent2;
        }
    }

    public Node findSet(String email)
    {
        Node node = map.get(email);
        if(node.parent==node)
            return node.parent;
        else
            return findSet(node.parent.email);
    }

    public String getOwner(String email)
    {
        return map.get(email).owner;
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Union uf = new Union();

        //Populating data
        for( int i = 0; i < accounts.size();i++)
        {
            String firstEmail = accounts.get(i).get(1);
            String owner = accounts.get(i).get(0);
            uf.makeSet(firstEmail,owner);
            for( int j = 2; j < accounts.get(i).size();j++)
            {
                String email = accounts.get(i).get(j);
                uf.makeSet(email,owner);
                uf.union(firstEmail,email);
            }
        }

        //Merging
        HashMap<String,TreeSet<String>> groups = new HashMap<>();
        for( int i = 0; i < accounts.size();i++)
        {
            if (accounts.get(i).size() <= 1) {
                continue;
            }

            Node parent = uf.findSet(accounts.get(i).get(1));
            if(!groups.containsKey(parent.email))
                groups.put(parent.email,new TreeSet<>());
            
            TreeSet<String> curGroup = groups.get(parent.email);
            for( int j = 1; j < accounts.get(i).size();j++)
            {
                curGroup.add(accounts.get(i).get(j));      
            }
        }

        List<List<String>> finalAccounts = new ArrayList<>();
        for(Map.Entry<String,TreeSet<String>> grp : groups.entrySet() )
        {
            List<String> account = new ArrayList<>();
            account.add(uf.getOwner(grp.getKey()));
            account.addAll(grp.getValue());
            finalAccounts.add(account);
        }
        return finalAccounts; 
    }
}
