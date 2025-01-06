<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Workout</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h3>Add New Workout</h3>
        <form action="addWorkout" method="POST">
            <div class="mb-3">
                <label for="date" class="form-label">Date</label>
                <input type="date" class="form-control" id="date" name="date" required>
            </div>
            <div class="mb-3">
                <label for="activity" class="form-label">Activity</label>
                <input type="text" class="form-control" id="activity" name="activity" required>
            </div>
            <div class="mb-3">
                <label for="duration" class="form-label">Duration (mins)</label>
                <input type="number" class="form-control" id="duration" name="duration" required>
            </div>
            <div class="mb-3">
                <label for="calories" class="form-label">Calories Burned</label>
                <input type="number" class="form-control" id="calories" name="calories" required>
            </div>
            <button type="submit" class="btn btn-primary">Save Workout</button>
        </form>
    </div>
</body>
</html>
