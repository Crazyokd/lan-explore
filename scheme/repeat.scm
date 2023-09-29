(define (list*2 ls)
	(if (null? ls)
		'()
		(cons (* 2 (car ls))
					(list*2 (cdr ls)))))


; 1.1
(define (my-length ls)
	(if (null? ls)
		0
		(+ 1 (my-length (cdr ls)))))

; 1.2
(define (ls-sum ls)
	(if (null? ls)
		0
		(+ (car ls) (ls-sum (cdr ls)))))


; 1.3
(define (ls-del-x ls x)
	(if (null? ls)
		'()
		(let ((h (car ls)))
			((if (eqv? x h)
				 (lambda (y) y)
				 (lambda (y) (cons h y)))
			 (ls-del-x (cdr ls) x)))))


; 1.4
(define (position x ls)
	(position-aux x ls 0))

(define (position-aux x ls index)
	(cond
		((null? ls) #f)
		((eqv? x (car ls)) index)
		(else (position-aux x (cdr ls) (+ index 1)))))


; 2.1
(define (my-reverse ls)
	(my-reverse-rec ls '()))

(define (my-reverse-rec ls0 ls1)
	(if (null? ls0)
		ls1
		(my-reverse-rec (cdr ls0) (cons (car ls0) ls1))))


; 2.2
(define (my-sum-tail ls)
	(my-sum-rec ls 0))

(define (my-sum-rec ls n)
	(if (null? ls)
		n
		(my-sum-rec (cdr ls) (+ n (car ls)))))


; 2.3
(define (my-string->integer str)
	(char2int (string->list str) 0))

(define (char2int ls n)
	(if (null? ls)
		n
		(char2int (cdr ls)
							(+ (- (char->integer (car ls)) 48))
							(* n 10))))


(define (range n)
	(let loop((i 0) (ls1 ()))
		(if (= i n)
			(reverse ls1)
			(loop (+ 1 i) (cons i ls1)))))
