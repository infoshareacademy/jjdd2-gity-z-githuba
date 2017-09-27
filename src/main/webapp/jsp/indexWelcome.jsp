<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container-full">

    <div class="row">

        <div class="col-lg-12 text-center v-center">

            <h1>Email Analyzer</h1>

            <br>

            <form class="col-lg-12">
                <div class="input-group input-group-lg col-sm-offset-4 col-sm-4">
                    <input class="center-block form-control input-lg" title="Upload First File." placeholder="Upload Your File" type="text">
                    <span class="input-group-btn"><button class="btn btn-lg btn-primary" type="button">...</button></span>
                </div>

                <br>

                <form class="col-lg-12">
                    <div class="input-group input-group-lg col-sm-offset-4 col-sm-4">
                        <input class="center-block form-control input-lg" title="Upload Second File." placeholder="Upload Your File" type="text">
                        <span class="input-group-btn"><button class="btn btn-lg btn-primary" type="button">...</button></span>
                    </div>

                    <br>

                    <form class="col-lg-12">
                        <div class="input-group input-group-lg col-sm-offset-4 col-sm-4">
                            <input class="center-block form-control input-lg" title="Upload Third File." placeholder="Upload Your File" type="text">
                            <span class="input-group-btn"><button class="btn btn-lg btn-primary" type="button">...</button></span>
                        </div>

                        <br>
                    </form>



                    <div class="form-group">
                        <label class="col-md-4 control-label" for="singlebutton"></label>
                        <div class="col-md-4">
                            <button id="singlebutton" name="singlebutton" class="btn btn-primary">Analyse!</button>
                        </div>
                    </div>
