<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form class="form-horizontal">
    <fieldset>

        <!-- Form Name -->
        <legend>Identify by the keywords</legend>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="selectbasic1">Is this an urgent message?</label>
            <div class="col-md-2">
                <select id="selectbasic1" name="selectbasic" class="form-control">
                    <option value="YES">Yes</option>
                    <option value="NO">No</option>
                </select>
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="selectbasic2">Is this a formal message?</label>
            <div class="col-md-2">
                <select id="selectbasic2" name="selectbasic" class="form-control">
                    <option value="Yes">Yes</option>
                    <option value="No">No</option>
                </select>
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="selectbasic3">Is this an important message</label>
            <div class="col-md-2">
                <select id="selectbasic3" name="selectbasic" class="form-control">
                    <option value="Yes">Yes</option>
                    <option value="No">No</option>
                </select>
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
                <button id="singlebutton" name="singlebutton" class="btn btn-primary">Give me the answers!</button>
            </div>
        </div>

        <!-- Textarea -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="textarea">Your Result:</label>
            <div class="col-md-4">
                <textarea class="form-control" id="textarea" name="textarea">&lt;empty&gt;</textarea>
            </div>
        </div>

    </fieldset>
</form>