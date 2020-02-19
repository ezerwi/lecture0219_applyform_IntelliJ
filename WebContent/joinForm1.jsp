<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.*, com.oreilly.servlet.MultipartRequest, com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
    
<%
	GregorianCalendar date = new GregorianCalendar();
	String datenow = String.format("%TY. %Tm. %Te.", date, date, date);
%>
<!DOCTYPE html>
<html>
<head>
<style>
	 input::-webkit-input-placeholder {
	 	text-align : "center";
	 	font-weight: "bolder";
	 	color : "red";
	 }
</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>이력서 작성</title>

</head>
<body>

<form action="joinForm1Check" method="POST" enctype="multipart/form-data">

<div align = "center" >
<h1>이  력  서</h1>

<p>
<table border = 1 >
	<colgroup>
		<col width = "150px">
		<col width = "270px">
		<col width = "180px">
		<col width = "270px">
		<col width = "180px">
		<col width = "250px">
	</colgroup>
	
	<tr>
	<th rowspan="2">성명</th>
	<td><input type = "text" name ="name_ko" placeholder = "(한 글 )" required="required"  /></td>
	<th >희망분야</th>
	<td><input type = "text" value = "프로그램 개발 엔지니어" readonly="readonly"  /></td>
	<th >작성일자</th>
	<td><input type = "text" name = "makedate" value = "<%=datenow %>" readonly="readonly"  /></td>
	</tr>
	
	<tr>
	<td><input type = "text" name ="name_en" placeholder = "(영 문 )" required="required"  /></td>
	<th >희망직무</th>
	<td><input type = "text" value = "프로그램 개발" readonly="readonly"  /></td>
	<th >추천인</th>
	<td><input type = "text" name = "refer_name"  /></td>
	</tr>
</table>
</p>

<p>
	<table border =1 >
	
		<colgroup>
			<col width="150px">
			<col width="900px">
			<col width="250px">
		</colgroup>
		
		<tr>
		<th>생년월일</th> <td><input type = "text" name = "birth" ></td> <td rowspan="4" align="center" >사진첨부 필수 <br/><input type="file" name="photo" value = "첨부하기" accept="image/*" /></td>
		</tr>
		
		<tr>
		<th>현주소</th> <td><input type = "text" name = "addr" ></td>
		</tr>
		
		<tr>
		<th>e-mail</th> <td><input type = "email" name = "email" ></td>
		</tr>
		
		<tr>
		<th>휴대폰</th> <td><input type = "text" name = "phone" pattern = "(010)-\d{3|4}-\d{4}" ></td>
		</tr>
		
	</table>
</p>	

<p>
	<table border = "1">
		<colgroup>
			<col width = "75px" >
			<col width = "75px" >
			<col width = "270px" >
			<col width = "550px" >
			<col width = "100px" >
			<col width = "75px" >
			<col width = "150px" >
		</colgroup>	
		<tr>
			<th rowspan="7"> 학력 사항 </th>
			<th colspan = "1">고교</th>
			<td colspan = "1"><input type = "text" name = "highs_year_f" pattern = "\d{4}">년 &nbsp; <input type = "text" name = "highs_month_f" pattern = "\d{2}">월 입학<br />
			<input type = "text" name = "highs_year_l" pattern = "\d{4}">년 &nbsp; <input type = "text" name = "highs_month_l" pattern = "\d{2}">월 졸업
			</td>
			<td colspan = "4"><input type = "text" name = "highs_name" /> 고등학교</td>
			
		</tr>
		
		<tr>
			<th>전문</th>
			<td colspan = "1"><input type = "text" name = "col_year_f" pattern = "\d{4}">년 &nbsp; <input type = "text" name = "col_month_f" pattern = "\d{2}">월 입학<br />
			<input type = "text" name = "col_year_l" pattern = "\d{4}">년 &nbsp; <input type = "text" name = "col_month_l" pattern = "\d{2}">월 졸업
			</td>
			<td colspan = "2"><input type = "text" name = "col_name" /> 대학 <input type = "text" name = "col_maj" /> 학과 ( 소재지 : <input type = "text" name = "col_loc" /> ) 
			</td>
			<td><select name = "col_addmaj">
			<option value = "submaj">부전공</option>
			<option value = "multimaj">복수전공</option>
			</select>
			</td>
			<td><input type = "text" name = "col_addmaj_name" /></td>
		</tr>
		
		<tr>
			<th>대학</th>
			<td colspan = "1"><input type = "text" name = "univ_year_f" pattern = "\d{4}">년 &nbsp; <input type = "text" name = "univ_month_f" pattern = "\d{2}">월 입학<br />
			<input type = "text" name = "univ_year_l" pattern = "\d{4}">년 &nbsp; <input type = "text" name = "univ_month_l" pattern = "\d{2}">월 졸업
			</td>
			<td colspan = "2"><input type = "text" name = "univ_name" /> 대학 <input type = "text" name = "univ_maj" /> 학과 ( 소재지 : <input type = "text" name = "univ_loc" /> ) 
			</td>
			<td><select name = "univ_addmaj">
			<option value = "submaj">부전공</option>
			<option value = "multimaj">복수전공</option>
			</select>
			</td>
			<td><input type = "text" name = "univ_addmaj_name" /></td>
		</tr>
		
		<tr>
			<th>석사</th>
			<td colspan = "1"><input type = "text" name = "mas_year_f" pattern = "\d{4}">년 &nbsp; <input type = "text" name = "mas_month_f" pattern = "\d{2}">월 입학<br />
			<input type = "text" name = "mas_year_l" pattern = "\d{4}">년 &nbsp; <input type = "text" name = "mas_month_l" pattern = "\d{2}">월 졸업
			</td>
			<td colspan = "4"><input type = "text" name = "mas_name" /> 대학 <input type = "text" name = "mas_maj" /> 학과 ( 소재지 : <input type = "text" name = "mas_loc" /> ) 
			</td>			
		</tr>
		
		<tr>
			<th>박사</th>
			<td colspan = "1"><input type = "text" name = "doc_year_f" pattern = "\d{4}">년 &nbsp; <input type = "text" name = "doc_month_f" pattern = "\d{2}">월 입학<br />
			<input type = "text" name = "doc_year_l" pattern = "\d{4}">년 &nbsp; <input type = "text" name = "doc_month_l" pattern = "\d{2}">월 졸업
			</td>
			<td colspan = "4"><input type = "text" name = "doc_name" /> 대학 <input type = "text" name = "doc_maj" /> 학과 ( 소재지 : <input type = "text" name = "doc_loc" /> ) 
			</td>			
		</tr>
		
		<tr>
			<th rowspan="2"></th>
			<th>세부전공</th>
			<td ><input type = "text" name = "grad_maj" placeholder="세부전공" /> </td>
			<td>논문제목</td>
			<td colspan = "2"><input type = "text" name = "article" placeholder="논문제목" /></td>
		</tr>
		
		<tr align="center">
			<th>휴학기간/사유</th>
			<td colspan = "5">휴학기간 <input type = "text" name = "pause_year_f" pattern="\d{4}" />년 <input type = "text" name = "pause_month_f" pattern="\d{2}" />월
			<input type = "text" name = "pause_year_l" pattern="\d{4}" />년 <input type = "text" name = "pause_month_l" pattern="\d{2}" />월 <br />
			휴학사유 <input type = "text" name = "pause_reason" pattern = "\w+" placeholder="휴학 사유 기입" />
			</td>
		</tr>
		
	</table>
</p>
	
</div>

<div align="right">
<input type = "submit" value = "인적사항 입력 완료!" style = "height : 55px; width : 300px; background-color: red; color : white;"/>
</div>

</form>

</body>
</html>