## con url

```
mongodb://<username>:<password>@<host>:<port>/<database>?authSource=<authDatabase>
```


## create user & grant access

```javascript
db.createUser({
    user: "testuser",
    pwd: "test123456",
    roles: [{
        role: "readWrite",
        db: "test-db"
    }]
})
```
