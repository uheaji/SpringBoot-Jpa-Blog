<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>

 <!-- Page Header -->
  <header class="masthead" style="background-image: url('../resources/img/flora.png')">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <div class="site-heading">
            <h1>게시글 작성</h1>
          </div>
        </div>
      </div>
    </div>
  </header>

<div class="container">
	<form action="/post" method="post">

		<div class="form-group">
			<input type="text" class="form-control" placeholder="Enter title" name="title" />
		</div>

		<div class="form-group">
			<textarea id="content" rows="" cols="5" class="form-control" name="content"></textarea>
		</div>

		<button type="submit" class="btn btn-primary">글쓰기완료</button>
	</form>
</div>


  <script>
        $('#content').summernote({
        	tabsize:2,
        	height: 300
        });
  </script>
  
<%@include file="../layout/footer.jsp"%>