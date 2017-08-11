<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<h2>Hello</h2>
<security:authorize access="!isAuthenticated() ">
	<a href="/registration">registration</a>
	<%-- 	<security:authentication property="principal.email"/> --%>
</security:authorize>
<security:authorize access="isAuthenticated()">
	<form:form action="/logout" method="POST" modelAttribute="user">
	<button>log Out</button>
	</form:form>
</security:authorize>
<div class="row">
	<div class="col-sm-6 col-sm-offset-3">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
			</ol>
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img src="/resources/img/chinese.jpg" alt="Chania">
				</div>
				<div class="item">
					<img src="/resources/img/chinese.jpg" alt="Chania">
				</div>
				<div class="item">
					<img src="/resources/img/chinese.jpg" alt="Flower">
				</div>
				<div class="item">
					<img src="/resources/img/chinese.jpg" alt="Flower">
				</div>
			</div>
			<a class="left carousel-control" href="#myCarousel" role="button"
				data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
				aria-hidden="true"></span> <span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel" role="button"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
	</div>
</div>