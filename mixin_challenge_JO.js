const userProfile = {
    name: null,
    address: null,
    city: null,
    state: null,
    zipcode: null,
    avatar: null,
}

function getProfileUpdate(){
    return prof = {
    name: 'Jon',
    address: '123 Smith St',
    city: 'Charlotte',
    state: 'North Carolina',
    zipcode: '28202',
    avatar: 'me.jpg',
}
}

function updateProfile() {
    Object.assign(userProfile, getProfileUpdate());
    console.log(userProfile);
}

updateProfile();