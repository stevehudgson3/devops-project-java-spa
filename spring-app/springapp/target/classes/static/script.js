document.getElementById('userForm').addEventListener('submit', async function(event) {
    event.preventDefault();
    
    const name = document.getElementById('name').value;
    const message = document.getElementById('message').value;
    
    const response = await fetch('/api/users', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ name, message })
    });
    
    if (response.ok) {
        loadUsers();
    }
});

async function loadUsers() {
    const response = await fetch('/api/users');
    const users = await response.json();
    
    const userList = document.getElementById('userList');
    userList.innerHTML = '';
    
    users.forEach(user => {
        const li = document.createElement('li');
        li.textContent = `${user.name}: ${user.message || 'No message'}`;
        userList.appendChild(li);
    });
}

loadUsers();
