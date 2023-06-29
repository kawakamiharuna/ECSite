<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<title>ホーム</title>
<!--  <link href="../css/home-pig.css" media="all" rel="stylesheet">
<link href="../slick/slick.css" media="all" rel="stylesheet">-->
<link rel="stylesheet" type="text/css" href="../css/home.css">
<link rel="stylesheet" type="text/css" href="../css/splash.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Caprasimo&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=M+PLUS+Rounded+1c:wght@900&display=swap" rel="stylesheet">


</head>

<%@page contentType="text/html; charset=UTF-8"%>

<body>
<div id="splash">
<div id="splash-logo">肝臓は元の15％があれば再生可能なんだ</div>
<!--/splash--></div>
<div class="splashbg"></div><!---画面遷移用-->
<div id="containers">
	<header><div class="header">

		<table>
			<td><img src="/ShoppingSite/img/header.png" alt="ロゴマーク"width="20px" height="20px"></td>
			<td>CellSell</td>
			<td><img src="/ShoppingSite/img/header.png" alt="ロゴマーク"width="20px" height="20px"></td>
			<td><a href="../all/all"
				onclick="event.preventDefault(); document.getElementById('myForm').submit();">商品一覧を見る</a></td>
			<td><a href="master/master.jsp">管理者</a></td>
		</table>
		<script>
			document.getElementById('submitButton').addEventListener('click',
					function(event) {
						event.preventDefault();
						document.getElementById('myForm').submit();
					});
		</script>
		<form action="../all/all" method="get" id="myForm">
			<!-- フォームの中身 -->
			<input type="submit" name="itemcontents" value="商品一覧を見る"
				style="display: none;">
		</form>
	</div></header>
	
	<main>
		<div class="welcome">
			<marquee scrollamount="7">
				<strong>Welcome to cellsell</strong> <strong>Welcome to
					cellsell</strong> <strong>Welcome to cellsell</strong>
			</marquee>
		</div>


		<div class="news">
			<figure class="image">
				<img src="../img/home11.jpg" alt="">
			</figure>
			<div class="right">
				<p class="title">光を使い神経回路の謎を解く手法を開発</p>
				<p class="text">手足を動かして行動したり、物事を考えたり覚えたり。
					脳を中心に、体に張りめぐらされた神経細胞は、ヒトをはじめ動物のあらゆる活動を支えている。 重要ではあるものの、極めて複雑で謎が深い。
					その解明を目指す神経科学に一大変革をもたらしたのが、光に反応するタンパク質を使って神経回路を調べる技術だ。</p>
			</div>
		</div>

		<div class="news">
			<figure class="image">
				<img src="../img/home21.jpg" alt="">
			</figure>
			<div class="right">
				<p class="title">微生物「ボルバキア」が引き起こす無視の性転換を細胞で再現</p>
				<p class="text">昆虫と共生する微生物の「ボルバキア」は昆虫に感染し、宿主の性をオスからメスに転換させるなど
					生殖システムを操作する。 農業・食品産業技術総合研究機構などは、害虫アズキノメイガの培養細胞を用いて「メス化」を再現し、
					遺伝子レベルで性転換メカニズムの一端を初めて明らかにした。</p>
			</div>
		</div>

		<div class="news">
			<figure class="image">
				<img src="../img/home31.jpg" alt="">
			</figure>
			<div class="right">
				<p class="title">胃がんのリスク「ピロリ×遺伝」で大幅に高まる理研など解明</p>
				<p class="text">胃がんの原因は、遺伝の要因もあるとされる。ただ、リスクの詳細は分かっていなかった。
					そこで研究グループは、胃がんのリスクに関連する遺伝子の特定や、環境要因と遺伝要因に加え、
					両者を組み合わせたリスクの度合いの解明に挑んだ。</p>
			</div>
		</div>

		<div class="news">
			<figure class="image">
				<img src="../img/home41.jpg" alt="">
			</figure>
			<div class="right">
				<p class="title">飢餓から命守る肝臓の働き発見、糖尿病に応用も</p>
				<p class="text">肝臓が飢餓を感じて血中に特別なタンパク質を放ち、カロリー消費を抑え、
					食欲を高める仕組みをマウスの実験で発見した。 糖尿病患者で血糖値が高い時にこの仕組みが働くことも判明し、
					食べ過ぎを防ぐ治療につながる可能性があるという。</p>
			</div>
		</div>		
	</main>


	<footer><%@include file="footer.jsp"%></footer>

</div>
<script src="../js/jquery-3.6.4.min.js"></script>

<!--自作のJS-->
<script src="../js/splash.js"></script>
</body>



</html>