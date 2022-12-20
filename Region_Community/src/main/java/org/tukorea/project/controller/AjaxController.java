package org.tukorea.project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("ajax")
public class AjaxController {

    @RequestMapping("select")
    public List<String> select
            (String si,String gu,HttpServletRequest request) {
        /*
         * BufferedReader : Reader => 문자형 입력스트림
         *   - readLine() 메서드를 멤버로 가짐
         *   - FilteredReader : 기존의 스트림에 필터 기능 추가
         *                      생성자에서 기존스트림을 제공해야함.
         */
        BufferedReader fr = null;
        //path : .txt 파일의 절대 경로.
        String path = "/Users/ijiyoon/Documents/GitHub/Region_CommunityService/Region_Community/src/main/webapp/file/sido.txt";
        try {
            //FileReader(path) : path 위치의 파일을 읽기 위한 스트림
            //fr : sido.txt 파일을 읽기 위한 스트림 객체
            fr = new BufferedReader(new FileReader(path));
        } catch(Exception e) {
            e.printStackTrace();
        }
        //Set : 중복불가.
        //LinkedHashSet : 중복불가. 순서 유지 가능
        Set<String> set = new LinkedHashSet<>();
        String data = null;
        //si,gu 파라미터값이 없는 경우 : 처음 화면 초기화시 파라미터값이 없는 경우
        if(si==null && gu == null) { //시도 데이터들을 리턴
            try {
                //readLine() : 한줄씩 읽기
                while((data=fr.readLine()) != null) {
                    //\\s+ : \\s : 공백, +:1개이상
                    //       공백한개이상으로 문자를 분리하여 배열 저장
                    String[] arr = data.split("\\s+");
                    if(arr.length >= 3) set.add(arr[0].trim());
                }
            }catch(IOException e) {
                e.printStackTrace();
            }
        } else if(gu == null) { //si 파라미터 존재
            si = si.trim();
            try {
                while ((data = fr.readLine()) != null) {
                    String[] arr = data.split("\\s+");
                    if(arr.length >= 3 && arr[0].equals(si) &&
                            !arr[1].contains(arr[0]) ) {
                        set.add(arr[1].trim()); //구정보 저장
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else { //si 파라미터,gu 파라미터 존재
            si = si.trim();
            gu = gu.trim();
            try {
                while ((data = fr.readLine()) != null) {
                    String[] arr = data.split("\\s+");
                    if(arr.length >= 3 && arr[0].equals(si) &&
                            arr[1].equals(gu) && !arr[0].equals(arr[1]) &&
                            !arr[2].contains(arr[1])) {
                        if(arr.length > 3 ) {
                            if(arr[3].contains(arr[1])) continue;
                            arr[2] += " " + arr[3];
                        }
                        set.add(arr[2].trim()); //동정보 저장
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        List<String> list = new ArrayList<>(set);
        return list; //배열로 브라우저(ajax객체)에 전달
    }


    @RequestMapping(value="select2", produces="text/plain; charset=utf-8")
    public String select2(String si, String gu, HttpServletRequest request) {
        BufferedReader fr = null;
        String path = "/Users/ijiyoon/Documents/GitHub/Region_CommunityService/Region_Community/src/main/webapp/file/sido.txt";
        try {
            fr = new BufferedReader(new FileReader(path));
        } catch(Exception e) {
            e.printStackTrace();
        }
        Set<String> set = new LinkedHashSet<>();
        String data = null;
        if(si==null && gu == null) {
            try {
                while((data=fr.readLine()) != null) {
                    String[] arr = data.split("\\s+");
                    if(arr.length >= 3) set.add(arr[0].trim());
                }
            }catch(IOException e) {
                e.printStackTrace();
            }
        }
        List<String> list = new ArrayList<>(set);
        System.out.println(list.toString());
        return list.toString(); //문자열로 브라우저(ajax객체)에 전달
    }
}
