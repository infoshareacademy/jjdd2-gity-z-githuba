<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css">
    <style>
        .row {
            margin-top: 40px;
            padding: 0 10px;
        }

        .clickable {
            cursor: pointer;
        }

        .panel-heading span {
            margin-top: -20px;
            font-size: 15px;
        }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/highLineEmails.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script language="JavaScript">
        $(document).ready(function () {

            var sentences = $('#sentences');
            var normal = $('#sentences');
            var keywords = $('#keywords');

            keywords.click(function () {

                var text = sentences.html();
                var selection = window.getSelection() || document.getSelection() || document.selection.createRange();
                var selObj = document.getSelection();
                var word = $.trim(selection.toString());
                if (word === '') {
                    word = event.target.innerText
                }
                var regex = new RegExp('(' + word + ')', 'ig');
                text = text.replace(regex, '<span style="background-color: yellow">$1</span>');
                sentences.html(text);
            });

            $("#success-alert").fadeTo(2000, 500).slideUp(500, function () {
                $("#success-alert").slideUp(500);
            });

            $(document).on('click', '.panel-heading span.clickable', function (e) {
                var $this = $(this);
                if (!$this.hasClass('panel-collapsed')) {
                    $this.parents('.panel').find('.panel-body').slideUp();
                    $this.addClass('panel-collapsed');
                    $this.find('i').removeClass('glyphicon-chevron-up').addClass('glyphicon-chevron-down');
                } else {
                    $this.parents('.panel').find('.panel-body').slideDown();
                    $this.removeClass('panel-collapsed');
                    $this.find('i').removeClass('glyphicon-chevron-down').addClass('glyphicon-chevron-up');
                }
            })
        });

    </script>
</head>
<body>
<jsp:include page="../shared/menu.jsp"/>
<div id="main">
    <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; </span>
    <div class="container">
        <c:if test="${not empty file}">
            <div class="alert alert-success" id="success-alert">
                <button type="button" class="close" data-dismiss="alert">x</button>
                <strong>Success!</strong> Everything went well!.
            </div>
            <br/>
        </c:if>
        <c:if test="${not empty keywords}">
        <div class="row">
            <div class="col-md-offset-0"></div>
            <div class="col-md-offset-0">
                <div class="panel-group">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Searched keywords:</h3>
                            <span class="pull-right clickable"><i class="glyphicon glyphicon-chevron-up"></i></span>
                        </div>
                        <div class="panel-body">
                            <div id="keywords">
                                <c:forEach var="keywords" items="${keywords}" varStatus="loop">
                                    <c:out value="[${loop.index+1}]"/>
                                    :
                                    <c:out value="${keywords}"/>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                    <br/>
                    </c:if>
                    <c:if test="${empty keywords}">
                        <div class="panel-group">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Keywords</h3>
                                    <span class="pull-right clickable"><i
                                            class="glyphicon glyphicon-chevron-up"></i></span>
                                </div>
                                <div class="panel-body">
                                    <div id="keywords">
                                        <p>Input searching word</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <br/>
                    </c:if>

                    <c:if test="${not empty question}">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Messages containing searched keywords</h3>
                                <span class="pull-right clickable"><i class="glyphicon glyphicon-chevron-up"></i></span>
                            </div>
                            <div class="panel-body">
                                <div id="sentences">
                                    <table class="table table-striped" style="width:100%;table-layout:fixed">
                                        <thead>
                                        <tr>
                                            <th scope="col" style="width:30%">From</th>
                                            <th scope="col" style="width:30%">Subject</th>
                                            <th scope="col" style="width:70%">Message</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="quest" items="${question}" varStatus="loop">
                                            <tr data-toggle="modal" data-target="#myModal${loop.index+1}">
                                                <td>
                                                    <c:out value="${quest.from}"/>
                                                </td>
                                                <td>
                                                    <c:out value="${quest.subject}"/>
                                                </td>
                                                <td style="word-wrap:break-word">
                                                    <c:out value="${quest.message}"/>
                                                </td>
                                            </tr>
                                            <div id="myModal${loop.index+1}" class="modal" role="dialog">
                                                <div class="modal-dialog">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal">
                                                                &times;
                                                            </button>
                                                            <h4 class="modal-title">Modal Header</h4>
                                                        </div>
                                                        <div class="modal-body" id="orderDetails">
                                                            <div class="row" style="margin-top:5px">
                                                                <div class="col-sm-4">From</div>
                                                                <div class="col-sm-8 wordwrap"><p
                                                                        class="text-primary">${quest.from}</p></div>

                                                            </div>
                                                            <div class="row" style="margin-top:5px">
                                                                <div class="col-sm-4">Subject</div>
                                                                <div class="col-sm-8 wordwrap"><p
                                                                        class="text-primary">${quest.subject}</p></div>

                                                            </div>
                                                            <div class="row" style="margin-top:5px">
                                                                <div class="col-sm-4">Message</div>
                                                                <div class="col-sm-8 wordwrap"><p
                                                                        class="text-primary">${quest.message}</p></div>

                                                            </div>
                                                            <div class="row" style="margin-top:5px">
                                                                <div class="col-sm-4">Sender</div>
                                                                <div class="col-sm-8 wordwrap"><p
                                                                        class="text-primary">${quest.sender}</p></div>

                                                            </div>
                                                            <div class="row" style="margin-top:5px">
                                                                <div class="col-sm-4">Date</div>
                                                                <div class="col-sm-8 wordwrap"><p
                                                                        class="text-primary">${quest.date}</p></div>

                                                            </div>
                                                            <div class="row" style="margin-top:5px">
                                                                <div class="col-sm-4">To</div>
                                                                <div class="col-sm-8 wordwrap"><p
                                                                        class="text-primary">${quest.to}</p></div>

                                                            </div>
                                                            <div class="row" style="margin-top:5px">
                                                                <div class="col-sm-4">Reply</div>
                                                                <div class="col-sm-8 wordwrap "><p
                                                                        class="text-primary">${quest.reply}</p></div>

                                                            </div>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-default"
                                                                    data-dismiss="modal">Close
                                                            </button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <br/>
                    </c:if>
                    <c:if test="${not empty foundEmails}">
                        <div class="panel-group">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Found email adresses</h3>
                                    <span class="pull-right clickable"><i
                                            class="glyphicon glyphicon-chevron-up"></i></span>
                                </div>
                                <div class="panel-body">
                                    <div id="keywords">
                                        <c:forEach var="foundEmails" items="${foundEmails}" varStatus="loop">
                                            <c:out value="[${loop.index+1}]"/>
                                            :
                                            <c:out value="${foundEmails}"/>
                                            <br>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <br/>
                    </c:if>
                    <c:if test="${empty question}">
                        <div class="panel-group">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Message not found</h3>
                                    <span class="pull-right clickable"><i
                                            class="glyphicon glyphicon-chevron-up"></i></span>
                                </div>
                                <div class="panel-body">
                                    <div id="keywords">
                                        <p>Sorry there are no matching messages</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <br/>
                    </c:if>
                    <c:if test="${not empty foundPhone}">
                        <div class="panel-group">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Phone numbers found</h3>
                                    <span class="pull-right clickable"><i
                                            class="glyphicon glyphicon-chevron-up"></i></span>
                                </div>
                                <div class="panel-body">
                                    <div id="keywords">
                                        <c:forEach var="foundPhone" items="${foundPhone}" varStatus="loop">
                                            <c:out value="[${loop.index+1}]"/>
                                            :
                                            <c:out value="${foundPhone}"/>
                                            <br>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <br/>
                    </c:if>
                    <c:if test="${not empty foundWebsites}">
                        <div class="panel-group">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Websites and links found</h3>
                                    <span class="pull-right clickable"><i
                                            class="glyphicon glyphicon-chevron-up"></i></span>
                                </div>
                                <div class="panel-body">
                                    <div id="keywords">
                                        <c:forEach var="foundWebsites" items="${foundWebsites}" varStatus="loop">
                                            <c:out value="[${loop.index+1}]"/>
                                            :
                                            <c:out value="${foundWebsites}"/>
                                            <br>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <br/>
                    </c:if>
                    <c:if test="${not empty goodcontact}">
                        <div class="panel-group">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Good contact</h3>
                                    <span class="pull-right clickable"><i
                                            class="glyphicon glyphicon-chevron-up"></i></span>
                                </div>
                                <div class="panel-body">
                                    <div id="contact">
                                        <c:forEach var="goodcontact" items="${goodcontact}" varStatus="loop">
                                            Key: <c:out value="${goodcontact.key}"/>
                                            Value: <c:out value="${goodcontact.value}"/>
                                            <br>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <br/>
                    </c:if>
                    <a href="${pageContext.request.contextPath}/jsp/choice.jsp" class="btn btn-default" type="button">Go
                        to home</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>