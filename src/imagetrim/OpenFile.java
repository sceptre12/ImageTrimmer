package imagetrim;


import java.io.*;

/**
 *
 * @author xthomas
 */
public class OpenFile {
   private String Path1;
   private String Path2;
   private File[] st1;
   private File[] st2;
   private File f1;
   private File f2;
   
   private void setPaths(){
       String p1 = "/home/xthom001/public_html/latinAmerica/img/latin-menu";
       String p2 = "/home/xthom001/public_html/latinAmerica/img/latin-extra";
       Path1 = p1;
       Path2 = p2;
   }   
   private String toLCase(String n){
       return n.toLowerCase();
   }   
   public void accessFiles(){
       setPaths();
            f1 = new File(Path1);
            f2 = new File(Path2);
           if(f1.isDirectory()){
               st1 = new File[f1.listFiles().length];
               st1 = f1.listFiles();
           }
           if(f2.isDirectory()){
               st2 = new File[f2.listFiles().length];
               st2 = f2.listFiles();
           }       
   }   
   public void listF1(){
       for (File st11 : st1) {
           System.out.println(st11.toString());
       }
   }
   public void listF2(){
       for (File st21 : st2) {
           System.out.println(st21.toString());
       }
   }
  
   public void TrimF1(){       
       for (File st11 : st1) {
           char[] str = toLCase(st11.toString()).trim().toCharArray();
           String path ="";
           for(int b = 0; b < str.length; b++){
               if(str[b] == ' '){
                   str[b] = '_';
               }
               path+=str[b];
           }
           st11.renameTo(new File(path));
       }
   }
   private boolean isEmpty(File[] f){
       return f.length == 0;
   }
   public void TrimF22(){
       for(int a=0; a < st2.length; a++){
           char[] str = st2[a].toString().trim().toLowerCase().toCharArray();
           String path=" ";
           for(int b = 0; b <str.length; b++){
               if(str[b] == ' '){
                   str[b] = '_';
               }
               path+=str[b];
           }           
           if(st2[a].isDirectory()){
               for(int c = 0; c < st2[a].listFiles().length; c++){
                   char[] str2 = st2[a].listFiles()[c].toString().trim().toLowerCase().toCharArray();
                   String paths = " ";
                   for(int d =0; d < str2.length; d ++){
                       if(str2[d] == ' '){
                           str2[d] = '_';
                       }
                       paths+=str2[d];
                   }
                   if(st2[a].listFiles()[c].isDirectory()){
                       for(int e = 0; e < st2[a].listFiles()[c].listFiles().length; e++){
                           char[] str3 = st2[a].listFiles()[c].listFiles()[e].toString().trim().toLowerCase().toCharArray();
                           String path2 = " ";
                           for(int f = 0; f < str3.length; f++){
                               if(str3[f] == ' '){
                                   str3[f] = '_';
                               }
                               path2+=str3[f];
                           }
                           st2[a].listFiles()[c].listFiles()[e].renameTo(new File(path2));
                       }
                   }
                   st2[a].listFiles()[c].renameTo(new File(paths));
               }
           }
           st2[a].renameTo(new File(path));
       }
   }
   public void TrimF2(){
        File[] d1 = new File[0];
        File[] d2 = new File[0];
        for(int a = 0; a < st2.length; a++){
            char[] str = toLCase(st2[a].toString().trim()).toCharArray();
            String path ="";
            for(int b=0; b < str.length; b++){
                if(str[b] == ' '){
                    str[b] = '_';
                }
                path+=str[b];
            }
            st2[a].renameTo(new File(path));
            if(st2[a].isDirectory() && isEmpty(d1)){
                d1 = new File[st2[a].listFiles().length];
                d1 = st2[a].listFiles();
            }else if(st2[a].isDirectory() && isEmpty(d2)){
                d2 = new File[st2[a].listFiles().length];
                d2 = st2[a].listFiles();
            }
        }
        for(int c =0; c < d1.length; c++){
            char[] str = toLCase(d1[c].toString().trim()).toCharArray();
            String path = " ";
            for(int d = 0; d < str.length; d ++){
                if(str[d] == ' '){
                    str[d] = '_';
                }
                path+=str[d];
            }
            d1[c].renameTo(new File(path));
        }
        for(int e =0; e < d2.length; e++){
            char[] str = toLCase(d2[e].toString().trim()).toCharArray();
            String path = " ";
            for(int f = 0; f < str.length; f++){
                if(str[f] == ' '){
                    str[f] = '_';
                }
                path+=str[f];
            }
            d2[e].renameTo(new File(path));
        }
   }
}
