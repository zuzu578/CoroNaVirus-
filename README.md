# CoroNaVirus-
# 공공데이터활용지원센터_코로나19 예방접종센터 현황
 참조 : https://www.data.go.kr/iim/api/selectAPIAcountView.do#/
# vue.js 와 spring 을 이용하여 코로나 바이러스 예방접종센터 data 를 rest api 호출 후 json data format 으로 화면에 rendering 해주는 토이프로젝트 
# 사용 방법 
#<img width="607" alt="스크린샷 2021-07-21 오후 12 41 14" src="https://user-images.githubusercontent.com/69393030/126427163-d8e80378-fa85-42dd-a5b9-829244e7b6db.png">

해당 api 를 호출 받기 위해 api 인증 키를 공공데이터 포털 사이트에 로그인 후 발급받습니다.
해당 api 키를 입력하고 queryString 으로 json 데이터 포맷을 받습니다. (server / client )
해당 api 데이터를 가공합니다.

# page => 페이지 수 (ex: 1페이지에 10개의 데이터 뿌리기 , 2페이지에 그다음 10개의 데이터 뿌리기) 
# queryString 예시 : 
https://api.odcloud.kr/api/15077603/v1/uddi:90bfb316-0caf-495b-92c0-c5cbc7bca1d9?page="+page+"&perPage=5&serviceKey=pIjdyg6yRnPqmwfTfG4m3TIDh518lq4lqoOgjavC5e1QPr3Vut5Dri2mQXpGfX5CbeusLqm9VNvju4fmvIkv0g%3D%3D

올바른 parameter 를 전달 하여 json data 를 가져옵니다. 

통신 방법 
# 1) vue.js 를 이용한 axios 
 <img width="607" alt="스크린샷 2021-07-21 오후 12 44 01" src="https://user-images.githubusercontent.com/69393030/126427396-43d25e65-dc3f-4141-8e55-d9d9914d8b88.png">

# 2) 서버 단에서 data transaction 후 , vue에 전달 하는 방법 (map 형태로 return 합니다.) 
<img width="905" alt="스크린샷 2021-07-21 오후 12 45 08" src="https://user-images.githubusercontent.com/69393030/126427451-5a74f9e3-d0e6-45d0-9711-fd2797f16708.png">
# 3) 결과 
<img width="905" alt="스크린샷 2021-07-21 오후 12 45 43" src="https://user-images.githubusercontent.com/69393030/126427518-cb59b021-bee0-4ded-b860-987801e17f22.png">

# 4) 기능 
# 페이징 을이용한 데이터 불러오기 


