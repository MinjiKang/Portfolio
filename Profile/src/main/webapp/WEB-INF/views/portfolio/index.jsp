<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Resume</title>
<link type="text/css" rel="stylesheet" href="resources/css/blue.css" />
<link type="text/css" rel="stylesheet" href="resources/css/print.css" media="print"/>

<!--[if IE 7]>
<link href="css/ie7.css" rel="stylesheet" type="text/css" />
<![endif]-->
<!--[if IE 6]>
<link href="css/ie6.css" rel="stylesheet" type="text/css" />
<![endif]-->

</head>
<body>
<!-- Begin Wrapper -->
<div id="wrapper">
  <div class="wrapper-top"></div>
  <div class="wrapper-mid">
    <!-- Begin Paper -->
    <div id="paper">
      <div class="paper-top"></div>
      <div id="paper-mid">
        <div class="entry">
          <!-- Begin Image -->
          <img class="portrait" src="resources/img/image.jpg" alt="John Smith" />
          <!-- End Image -->
          <!-- Begin Personal Information -->
          <div class="self">
            <h1 class="name">${Personal_Info.my_name}<br/><br/><br/>
              <span></span></h1>
            <ul>
              <li class="ad">${Personal_Info.my_address }</li>
              <li class="mail">${Personal_Info.my_email }</li>
              <li class="tel">${Personal_Info.my_phone }</li>

            </ul>
          </div>
          <!-- End Personal Information -->
          <!-- Begin Social -->
          <div class="social">
            <ul>
              <li><a class='north' href="#" title="Download .pdf"><img src="resources/img/icn-save.jpg" alt="Download the pdf version" /></a></li>
              <li><a class='north' href="javascript:window.print()" title="Print"><img src="resources/img/icn-print.jpg" alt="" /></a></li>
              <li><a class='north' id="contact" href="contact/index.html" title="Contact Me"><img src="resources/img/icn-contact.jpg" alt="" /></a></li>
              <li><a class='north' href="#" title="Follow me on Twitter"><img src="resources/img/icn-twitter.jpg" alt="" /></a></li>
              <li><a class='north' href="#" title="My Facebook Profile"><img src="resources/img/icn-facebook.jpg" alt="" /></a></li>
            </ul>
          </div>
          <!-- End Social -->
        </div>
        <!-- Begin 1st Row -->
        <div class="entry">
          <h2>OBJECTIVE</h2>
          <c:forEach var="Objective" items="${Objective}">
          <p>${Objective.obj_content}<br></br></p>
          </c:forEach>
        </div>
        <!-- End 1st Row -->
        <!-- Begin 2nd Row -->
        <div class="entry">
          <h2>EDUCATION</h2>
          <div class="content">
            <h3>${Education.edu_date}</h3>
            <p>${Education.edu_school}, ${Education.edu_city} <br />
              <em>${Education.edu_major}</em></p>
          </div>
        </div>
        <!-- End 2nd Row -->
        <!-- Begin 3rd Row -->
        <div class="entry">
          <h2>EXPERIENCES</h2>
          <c:forEach var="Experience" items="${exp}">
          <div class="content">
            <h3>${Experience.exp_date}</h3>
            <p>${Experience.exp_place}<br/></p>
            <c:forEach var="ExperiencesContent" items="${ExperiencesContent}">
            <c:if test="${Experience.exp_no eq ExperiencesContent.exp_no}">
            <ul class="info">
              <li>${ExperiencesContent.exp_content}</li>
            </ul>
            </c:if>
            </c:forEach>
          </div>
          
          </c:forEach>
        </div>
        <!-- End 3rd Row -->
        <!-- Begin 4th Row -->
        <div class="entry">
          <h2>SKILLS</h2>
          <div class="content">
            <h3>Tools</h3>
            <c:forEach var="Skills" items="${Skills}">
	            <p>${Skills.skill_tool}</p>
            </c:forEach>
          </div>
          <div class="content">
            <h3>Languages</h3>
            <c:forEach var="Skills" items="${Skills}">
	            <p>${Skills.skill_software}</p>
            </c:forEach>
          </div>
        </div>
        <!-- End 4th Row -->
        <!-- Begin 5th Row -->
        <div class="entry">
          <h2>ACTIVITIES</h2>
          <c:forEach var="Activities" items="${Activities}">
          <p>${Activities.act_content }<br></br></p>
          </c:forEach>
        </div>
        <!-- End 5th Row -->
         <!-- Begin 6th Row -->
        <div class="entry">
        <h2>WORKS</h2>
        <div class="content">
        <c:forEach var="Works" items="${Works}">
	        	<h3>${Works.work_date}</h3>
		            <p>${Works.work_content}<br></br></p>
        </c:forEach>
        </div>
        </div>
        <!-- End 6th Row -->
        <!-- Begin 7th Row -->
      </div>
      <div class="clear"></div>
      <div class="paper-bottom"></div>
    </div>
    <!-- End Paper -->
  </div>
  <div class="wrapper-bottom"></div>
</div>
<div id="message"><a href="#top" id="top-link">Go to Top</a></div>
<!-- End Wrapper -->
</body>
</html>
