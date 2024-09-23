<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>YouTube</title>
    <link
      rel="icon"
      href="https://www.youtube.com/s/desktop/ae4ecf92/img/favicon_144x144.png"
    />
  <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
  </head>
  <body>
  	<jsp:include page="header.jsp"/>
	<main>
		<aside>
			<a href=""> <i class="fa-solid fa-house"></i> <span>홈</span>
			</a> <a href=""> <i class="fa-solid fa-folder"></i> <span>구독</span>
			</a>
		</aside>
		<div class="main-content">
			<nav>
				<a href="" class="active">전체</a> <a href="">음악</a> <a href="">게임</a>
				<a href="">뉴스</a> <a href="">라이브</a> <a href="">야생생물</a>
			</nav>
			<section>
				<c:forEach items="${list}" var="video">
					<div class="video-card" data-code="${video.videoCode}">
						<div class="video-main">
							<img src="http://192.168.10.51:8082/thumbnail/akmu.webp" />
							<video src="http://192.168.10.51:8082/video/AKMU1.mp4" controls></video>
						</div>
						<div class="video-info">
							<img src="http://192.168.10.51:8082/channel/akmu.jpg" />
							<div class="video-desc">
								<h4>${video.videoTitle}</h4>
								<p>${video.channel.channelName}</p>
								<p class="video-meta" data-video-date="${video.videoDate}">
									조회수 ${video.videoCount}회ㆍ<span class="video-date"></span>
								</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</section>
		</div>
	</main>

	<script>
    let page = 1;
    window.addEventListener("scroll", () => {
    	//console.log(window.innerHeight); // 브라우저 창의 보이는 영역 높이
    	//console.log(window.scrollY); // 현재 스크롤 위치
    	//console.log(document.body.offsetHeight); // 전체 웹 페이지 높이
    	//console.log(window.innerHeight + window.scrollY + 100); // 오차범위로 인한 추가
    	if(document.body.offsetHeight <= (window.innerHeight + window.scrollY + 10)) {
    		page++;
    		$.ajax({
    			url: '/list',
    			type: 'GET',
    			data: {page : page},
    			success: function(videos) {
    				let section = $("section");
    				$.each(videos, function(index, video) {
    					let videoCard = 
    						'<div class="video-card" data-code="' + ${video.videoCode} + '">
    			              '<div class="video-main">' + 
    			                '<img src="' + ${video.videoImg}'" />' +
    			                '<video src="' + ${video.videoUrl} + '"
    			                  controls></video>' +
    			              '</div>' +
    			              '<div class="video-info">' +
    			                '<img src="' + ${video.channel.channelImg} + '" />' +
    			                '<div class="video-desc">' +
    									'<h2>' + ${video.videoTitle} + '</h2>' +
    									'<p>' + ${video.channel.channelName} + '</p>' +
    									'<p class="video-meta" data-video-date="' + ${video.videoDate} + '">' +
    									'조회수 ' + ${video.videoCount} + '회ㆍ<span class="video-date"></span>' + '</p>' +
    			                '</div>' +
    			              '</div>' +
    			            '</div>';
    					section.append(videoCard);
    				});
    			}
    		})
    		
    	}
    });
    </script>
	<script src="${pageContext.request.contextPath}/js/script.js"></script>
	<script src="${pageContext.request.contextPath}/js/time.js"></script>
</body>
</html>
