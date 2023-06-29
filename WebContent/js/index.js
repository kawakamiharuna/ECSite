window.addEventListener('load', function() {
  var matrixDiv = document.querySelector('.matrix');
  matrixDiv.style.display = 'block';
});
let fadeInTarget = document.querySelectorAll('.fade-in');
window.addEventListener('scroll', () => {
  for (let i = 0; i < fadeInTarget.length; i++){
    const rect = fadeInTarget[i].getBoundingClientRect().top;
    const scroll = window.pageYOffset || document.documentElement.scrollTop;
    const offset = rect + scroll;
    const windowHeight = window.innerHeight; // 現在のブラウザの高さ
    if (scroll > offset - windowHeight + 250) {
      fadeInTarget[i].classList.add('scroll-in');
    }
  }
});
// 要素の取得
const largeTextElement = document.querySelector('.bg-wrap-large .inn');
const smallTextElement = document.querySelector('.bg-wrap-small .inn');

// 初期設定（非表示）
largeTextElement.style.opacity = '0';
smallTextElement.style.opacity = '0';

// アニメーションの設定
largeTextElement.style.transition = 'opacity 1.5s ease-in-out';
smallTextElement.style.transition = 'opacity 1.5s ease-in-out';
1
// アニメーションの開始
window.addEventListener('load', () => {
  largeTextElement.style.opacity = '1';
  smallTextElement.style.opacity = '1';

  // 3秒後に透明度を元に戻す
  setTimeout(() => {
    largeTextElement.style.opacity = '0';
    smallTextElement.style.opacity = '0';
  }, 3000); // 3000ミリ秒（3秒）
});