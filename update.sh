today = `date +%Y%m%d`
git add --all
git commit -m "$today $1"
git push
