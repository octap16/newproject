<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<%@ page import="ua.entity.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
   <%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
   <div class="row">
                <div class="col-lg-12">
	<div class="form">
      <ul class="tab-group">
        <li class="tab active"><a href="#signup">Sign Up</a></li>
        <li class="tab"><a href="#login">Log In</a></li>
      </ul>
      <div class="tab-content">
        <div id="signup">   
          <h1>Sign Up</h1>
          <form:form  action="/registration" method="POST" modelAttribute="user">
         
          <div class="top-row">
            <div class="field-wrap">
              <label>
                First Name<span class="req">*</span>
              </label>
              <form:input type="text" path="firstname" autocomplete="off" />
            </div>
            <div class="field-wrap">
              <label>
                Last Name<span class="req">*</span>
              </label>
            <form:input type="text" path="lastname"  autocomplete="off"/>
            </div>
          </div>
          <div class="field-wrap">
            <label>
              Email Address<span class="req">*</span>
            </label>
           <form:input path="email" type="email"  autocomplete="off"/>
           <form:errors path="email"/>
          </div>   
          <div class="field-wrap">
            <label>
              Set A Password<span class="req">*</span>
            </label>
           <form:input  path="password" type="password"  autocomplete="off"/>
          </div>
          <button type="submit" class="button button-block"/>Get Started</button>
          </form:form>
        </div>
        <div id="login">   
          <h1>Welcome</h1>
          <form:form action="/login" method="POST">
            <div class="field-wrap">
            <label>
              Email Address<span class="req">*</span>
            </label>
           <input  name="email" type="email" autocomplete="off"/> 
          </div>
          <div class="field-wrap">
            <label>
              Password<span class="req">*</span>
            </label>
            <input  name="password" type="password"  autocomplete="off"/>
          </div>
          <p class="forgot"><a href="#">Forgot Password?</a></p>
          <button class="button button-block"/>Log In</button>  
          </form:form>
        </div>
      </div><!-- tab-content -->
</div> <!-- /form -->
</div>
</div>