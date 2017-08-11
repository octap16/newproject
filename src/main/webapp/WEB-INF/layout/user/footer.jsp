<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
				<footer>
				<div class="row" style="margin-right: 0px;">
					<div class="col-md-12 " style=" height:200px; text-align: center;" >
					<div><security:authorize access="hasRole('ROLE_ADMIN')">
					<a href="/admin" ><h1 style="color:white; font-size:30px; text-align: center;">admin</h1></a>
						</security:authorize></div>
						<i class="fa fa-github" aria-hidden="true" style="font-size: 40px; padding-top: 5%;"></i>
				</div>
			</footer>