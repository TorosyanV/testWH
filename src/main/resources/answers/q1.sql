SELECT name, votes, FIND_IN_SET( votes, (
SELECT GROUP_CONCAT( votes
ORDER BY votes DESC )
FROM votes )
) AS rank
FROM votes