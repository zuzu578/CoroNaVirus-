<template>
  <div>
      <h1> 코로나 예방접종센터 현황 </h1>
      <!-- 현재 페이지를 임시로 보여줍니다-->
      <input type="hidden" name="current_page" id="current_page" value='1'>


       <div class="board_view_area" v-for="(jData, idx) in boardData" :key="idx">
        <div class="centerName">
        센터명 : {{jData.센터명}}
        </div>
        <div class="centerPhoneNumber">
        사무실 전화번호 : {{jData.사무실전화번호}}
        </div>
        <div class="centerType">
        센터유형 : {{jData.센터유형}}
        </div>
        <div class="centerInfrastructureName">
        시설명 : {{jData.시설명}}
        </div>
        <div class="centerPostName">
        우편번호 : {{jData.우편번호}}
        </div>
        <div class="centerManageMentName">
        운영기관 : {{jData.운영기관}}
        </div>
        <div class="centerAddress">
        주소: {{jData.주소}}
        </div>
        </div>
        <!-- 데이터가 없는경우 -->
    <a v-if="boardData.length == 0" class="list-group-item list-group-item-action">
      데이터가 존재하지 않습니다.
    </a>
  
        <!-- pageNation Area !-->
<div class="paging">
  <nav aria-label="Page navigation example">
  <ul class="pagination">
    
    <li class="page-item" @click="prev()">prev</li> 
    <li class="page-item" @click="next()">next</li>
    
  </ul>
</nav>
</div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
data(){
    return{
        boardData:'',
        defaultPageNum : '',
    }

},
created(){
 
},
mounted(){
    // 초기 첫페이지에 해당하는 데이터를 가져옵니다.
    var current = document.getElementById('current_page').value
    console.log(current);
    this.defaultPageNum = current;
    console.log(this.defaultPageNum);
    axios.get('http://localhost:8082/myapp/getCoronaData',{
    params: {
        defaultPageNum : this.defaultPageNum
    }
    })
        
    .then((res)=>{
        //get Data List 
        console.log(res.data.data);
        this.boardData = res.data.data;
    })
    
},
methods:{
     //이전페이지 보여주기 
    prev(){
      var pageNum = document.getElementById('current_page').value
      var currentPageNum = parseInt(pageNum) -1;
       document.getElementById('current_page').value = currentPageNum;
      //alert(currentPageNum);
      console.log(currentPageNum)
      this.defaultPageNum = currentPageNum;
      console.log("현재 페이지 ==> " + this.defaultPageNum);
      if(this.defaultPageNum <= 0 ){
          console.log("이전 데이터가 없습니다.")
          // - 값이 된 페이지를 초기 값으로 복원합니다.
          this.defaultPageNum = 1;
          return false;
      }
       axios.get('http://localhost:8082/myapp/getCoronaData',{
        params: {
        defaultPageNum : this.defaultPageNum
        }
    }) 
    .then((res)=>{
        //get Data List 
        console.log(res.data.data);
        this.boardData = res.data.data;
    })
      
      
    },
    //다음페이지 보여주기 
    next(){
      var pageNum = document.getElementById('current_page').value
      var currentPageNum = parseInt(pageNum) +1;
      document.getElementById('current_page').value = currentPageNum;
      //alert(currentPageNum);
      console.log(currentPageNum)
      this.defaultPageNum = currentPageNum;
      console.log("현재 페이지 ==> " + this.defaultPageNum);
      axios.get('http://localhost:8082/myapp/getCoronaData',{
        params: {
        defaultPageNum : this.defaultPageNum
        }
    }) 
    .then((res)=>{
        //get Data List 
        console.log(res.data.data);
        this.boardData = res.data.data;
    })
    }
}
}
</script>

<style>
.page-item{
    width:50px;
    border:1px solid black;
    font-weight:bold;
    cursor: pointer;
}
@import 'https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css'

</style>