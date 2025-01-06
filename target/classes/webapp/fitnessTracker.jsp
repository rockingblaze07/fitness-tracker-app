<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fitness Tracker</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h3>Workout Log</h3>
        <table class="table">
            <thead>
                <tr>
                    <th>Date</th>
                    <th>Activity</th>
                    <th>Duration (mins)</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="workout" items="${workoutList}">
                    <tr>
                        <td>${workout.date}</td>
                        <td>${workout.activity}</td>
                        <td>${workout.duration}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
