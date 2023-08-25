package functional.oops;

import java.util.*;

class Employee11{
    String name,dept,doj,salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
public class Demo {
    public static void main(String[] args) {
        Map<String,Map<String,String>> employeeMapEnv1 = new HashMap<>();
        Map<String,String> empdetMap1= new HashMap();
        empdetMap1.put("NAME","Employee-1");
        empdetMap1.put("DEPT","Accounts");
        empdetMap1.put("DOJ","19-Jan-2000");
        empdetMap1.put("GROSS_SALARY","100000");
        employeeMapEnv1.put("emp1", empdetMap1);

        Map<String,String> empdetMap2= new HashMap();
        empdetMap2.put("NAME","Employee-2");
        empdetMap2.put("DEPT","Marketing");
        empdetMap2.put("DOJ","19-Jan-2010");
        empdetMap2.put("GROSS_SALARY","100000");
        employeeMapEnv1.put("emp2", empdetMap2);

        Map<String,String> empdetMap3= new HashMap();
        empdetMap3.put("NAME","Employee-3");
        empdetMap3.put("DEPT","Dispatch");
        empdetMap3.put("DOJ","19-Jan-2019");
        empdetMap3.put("GROSS_SALARY","100000");
        employeeMapEnv1.put("emp3", empdetMap3);

        //Env2:
        Map<String,Map<String,String>> employeeMapEnv2 = new HashMap();
        Map empdetMap11= new HashMap();
        empdetMap11.put("NAME","Employee-1");
        empdetMap11.put("DEPT","Marketing");
        empdetMap11.put("DOJ","19-Jan-2000");
        empdetMap11.put("GROSS_SALARY","100000");
        employeeMapEnv2.put("emp1", empdetMap11);

        Map<String,String> empdetMap22= new HashMap();
        empdetMap22.put("NAME","Employee-2");
        empdetMap22.put("DEPT","Marketing");
        empdetMap22.put("DOJ","19-Jan-2012");
        empdetMap22.put("GROSS_SALARY","100000");
        employeeMapEnv2.put("emp2", empdetMap22);

        Map<String,String> empdetMap33= new HashMap();
        empdetMap33.put("NAME","Employee-3");
        empdetMap33.put("DEPT","Dispatch");
        empdetMap33.put("DOJ","19-Jan-2019");
        empdetMap33.put("GROSS_SALARY","110000");
        employeeMapEnv2.put("emp3", empdetMap33);

        for(Map.Entry entry:employeeMapEnv2.entrySet()){
            Object key = entry.getKey();
            Map<String,Employee> map = (Map<String, Employee>) entry.getValue();
            System.out.println(map);
            if(employeeMapEnv2.containsValue(employeeMapEnv1.get(key))){
                System.out.println(key+" is differnce from employeeMapEnv1"+entry.getValue());
            }
        }
        employeeMapEnv2.entrySet().stream().forEach((v)->{

        });

        List<Integer> list = new ArrayList<>();
        list.add(getValue(10));
        System.out.println(list);
        String str = "test";
        Map<Character,Integer>map = new LinkedHashMap<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }else {
                map.put(ch,1);
            }
        }
        for (Map.Entry<Character,Integer> entry:map.entrySet()){
            if(entry.getValue()==1){
                System.out.println(entry.getKey());
                break;
            }
        }
        System.out.println(map.entrySet().stream().filter(item->item.getValue()==1).findFirst().get().getKey());
    }
    public static Integer getValue(Integer val){
        if(val!=null)
            return val;
        else
            throw new RuntimeException("null value is not allowed");
    }
}
