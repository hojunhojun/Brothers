//이미지 삽입
document.addEventListener('DOMContentLoaded', function() {
   function c2cLoadFile(input) {
      const file = input.files[0];
      if (file) {
         const delPhoto = document.querySelector('.c2cPhotos');
         while (delPhoto.firstChild) {
         delPhoto.removeChild(delPhoto.firstChild);
         }
         var newImage = document.createElement("img");
         newImage.src = URL.createObjectURL(file);
         newImage.style.width = "100px";
         newImage.style.height = "100px";
         newImage.style.objectFit = "contain";
         var container = document.querySelector('.c2cPhotos');
         container.appendChild(newImage);
      }
   }
   document.getElementById('c2cImg').addEventListener('change', function() {
      c2cLoadFile(this);
   });
});

document.addEventListener('DOMContentLoaded', function() {
   function c2cLoadEditFile(input) {
      var file = input.files[0];
      if (file) {
         const delPhoto = document.querySelector('.c2cEditPhotos');
         while (delPhoto.firstChild) {
         delPhoto.removeChild(delPhoto.firstChild);
         }
         var newImage = document.createElement("img");
         newImage.src = URL.createObjectURL(file);
         newImage.style.width = "100px";
         newImage.style.height = "100px";
         newImage.style.objectFit = "contain";
         var container = document.querySelector('.c2cEditPhotos');
         container.appendChild(newImage);
      }
   }
   document.querySelector('.c2cEditImg').addEventListener('change', function() {
      c2cLoadEditFile(this);
   });
});
//글쓰기 등장
function c2cWrite() {
   const writeTable = document.querySelector('.writeBox');
   const darkBg = document.querySelector('.dark');
   const computedStyle = window.getComputedStyle(writeTable);
   if (computedStyle.display === 'none') {
      writeTable.style.display = 'block';
      darkBg.style.display = 'block';
      console.log("테이블이 나타났습니다.");
   }
}
//글쓰기 취소
function cancleTbl() {
   event.preventDefault();
   console.log("클릭됨");
   const writeTable = document.querySelector('.writeBox');
   const darkBg = document.querySelector('.dark');
   if (writeTable.style.display !== 'none') {
      writeTable.style.display = 'none';  // 테이블 숨기기
      darkBg.style.display = 'none';
      console.log("테이블이 숨겨졌습니다.");
   }
}
function c2cUpdateGo(){
   const editTable = document.querySelector('.editBox');
   const darkBg = document.querySelector('.dark');
   const computedStyle = window.getComputedStyle(editTable);
      if (computedStyle.display === 'none') {
         editTable.style.display = 'block';
         darkBg.style.display = 'block';
         console.log("테이블이 나타났습니다.");
      }
}
function cancleEditTbl() {
   event.preventDefault();
   console.log("클릭됨");
   const editTable = document.querySelector('.editBox');
   const darkBg = document.querySelector('.dark');
   if (editTable.style.display !== 'none') {
      editTable.style.display = 'none';  // 테이블 숨기기
      darkBg.style.display = 'none';
      console.log("테이블이 숨겨졌습니다.");
   }
}
//요청등장
document.addEventListener('DOMContentLoaded', function() {
   // "요청 보내기" 버튼 클릭 이벤트 추가
   document.querySelectorAll('.reqBtn').forEach(function(button) {
      button.addEventListener('click', function() {
         const table = this.closest('.c2cTable'); // 버튼이 속한 테이블 찾기
         const reqBox = table.querySelector('.reqBox'); // 해당 테이블의 reqBox 찾기
         const darkBg = document.querySelector('.dark');
         if (reqBox) {
            const computedStyle = window.getComputedStyle(reqBox);
            if (computedStyle.display === 'none') {
               reqBox.style.display = 'block';
               darkBg.style.display = 'block';
               console.log("해당 테이블의 reqBox가 나타났습니다.");
            }
         }
      });
   });
});
//요청 취소
function cancleReq(){
	event.preventDefault();
	console.log("클릭됨");
    const button = event.target; // 클릭된 버튼
    const table = button.closest('.c2cTable');
    const reqBox = table.querySelector('.reqBox');
    const darkBg = document.querySelector('.dark');
    if (reqBox && reqBox.style.display !== 'none') {
        	reqBox.style.display = 'none'; 
        	darkBg.style.display = 'none'; 
        	console.log("테이블이 숨겨졌습니다.");
    }
}
function openClick(clickedElement) {
	   // 클릭된 tr의 부모인 .c2cTable을 찾아 해당 .c2cInfo를 찾음
	   const table = clickedElement.closest('.c2cTable');  // 클릭된 tr의 부모 .c2cTable
	   const infoTable = table.querySelector('.c2cInfo');  // 해당 c2cTable 내의 c2cInfo
	   const darkBg = document.querySelector('.dark');  // .dark는 하나만 존재하므로 선택
	   if (infoTable && window.getComputedStyle(infoTable).display === 'none') {
	      infoTable.style.display = 'block';
	      if (darkBg) {
	         darkBg.style.display = 'block';
	      }
	   }
	}
function cancleInfo(clickedElement) {
	   // 모든 .c2cInfo를 숨기기
	   const allInfoTables = document.querySelectorAll('.c2cInfo');
	   allInfoTables.forEach(info => {
	      info.style.display = 'none';
	   });

	   // dark 배경 숨기기
	   const darkBg = document.querySelector('.dark');
	   if (darkBg) {
	      darkBg.style.display = 'none';
	   }
	}